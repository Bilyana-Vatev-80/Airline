package softuni.exam.models.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "planes")
public class Plane extends BaseEntity{
    private String registerNumber;
    private Integer capacity;
    private String airline;

    public Plane() {
    }

    @Column(unique = true)
    @Length(min = 5)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Column
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Column
    @Length(min = 2)
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
