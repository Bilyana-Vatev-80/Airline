package softuni.exam.models.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneSeedDto {

    @XmlElement(name = "register-number")
    private String registerNumber;
    @XmlElement
    private Integer capacity;
    @XmlElement
    private String airline;

    @Length(min = 5)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Positive
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Length(min = 2)
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
