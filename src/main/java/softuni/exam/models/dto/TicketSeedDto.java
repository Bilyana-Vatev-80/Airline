package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "ticket")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketSeedDto {
    @XmlElement(name = "serial-number")
    private String serialNumber;
    @XmlElement
    private BigDecimal price;
    @XmlElement(name = "take-off")
    private String takeOff;
    @XmlElement(name = "from-town")
    private TicketFromTownDto fromTown;
    @XmlElement(name = "to-town")
    private TicketToTownDto toTown;
    @XmlElement(name = "passenger")
    private TickedPassengerSeedDto passenger;
    @XmlElement(name = "plane")
    private TickedPlaneSeedDto plane;

    @Length(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @NotNull
    public String getTakeOff() {
        return takeOff;
    }

    public void setTakeOff(String takeOff) {
        this.takeOff = takeOff;
    }

    @NotNull
    public TicketFromTownDto getFromTown() {
        return fromTown;
    }

    public void setFromTown(TicketFromTownDto fromTown) {
        this.fromTown = fromTown;
    }

    @NotNull
    public TicketToTownDto getToTown() {
        return toTown;
    }

    public void setToTown(TicketToTownDto toTown) {
        this.toTown = toTown;
    }

    @NotNull
    public TickedPassengerSeedDto getPassenger() {
        return passenger;
    }

    public void setPassenger(TickedPassengerSeedDto passenger) {
        this.passenger = passenger;
    }

    @NotNull
    public TickedPlaneSeedDto getPlane() {
        return plane;
    }

    public void setPlane(TickedPlaneSeedDto plane) {
        this.plane = plane;
    }
}
