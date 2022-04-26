package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnfermedadRepository extends JpaRepository<Enfermedad,Long> {
    Enfermedad getEnfermedadByIcd(long icd);
}
