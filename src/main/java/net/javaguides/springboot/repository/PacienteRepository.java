package net.javaguides.springboot.repository;

import net.javaguides.springboot.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
