package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerSeedDto;
import softuni.exam.models.entity.Passenger;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class PassengerServiceImpl implements PassengerService {
    public static final String PASSENGER_FILE_PATH = "src/main/resources/files/json/passengers.json";
    private final PassengerRepository passengerRepository;
    private final TownService townService;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public PassengerServiceImpl(PassengerRepository passengerRepository, TownService townService, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.passengerRepository = passengerRepository;
        this.townService = townService;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGER_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readPassengersFileContent(), PassengerSeedDto[].class))
                .filter(passengerSeedDto -> {
                    boolean isValid = validationUtil.isValid(passengerSeedDto);
                    stringBuilder
                            .append(isValid ? String.format("Successfully imported Passenger %s - %s",passengerSeedDto.getLastName(),
                                    passengerSeedDto.getEmail()) : "Invalid Passenger")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(passengerSeedDto -> {
                    Passenger passenger = modelMapper.map(passengerSeedDto, Passenger.class);
                    passenger.setTown(townService.getTownByName(passengerSeedDto.getTown()));
                    return passenger;
                })
                .forEach(passengerRepository::save);
        return stringBuilder.toString();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        return null;
    }

    @Override
    public Passenger getByEmail(String email) {
        return passengerRepository.findByEmail(email);
    }
}
