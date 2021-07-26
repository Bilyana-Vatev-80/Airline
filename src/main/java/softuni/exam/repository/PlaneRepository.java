package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Plane;

import javax.persistence.Entity;

@Repository
public interface PlaneRepository  extends JpaRepository<Plane,Long> {
    Plane findByRegisterNumber(String registerNumber);
}
