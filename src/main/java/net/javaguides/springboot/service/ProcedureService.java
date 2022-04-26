package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Appointment;
import net.javaguides.springboot.model.Procedures;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.List;

public interface ProcedureService {
    List<Procedures> getAllProcedures();

    Procedures saveProcedure(Procedures procedimiento);

    Procedures getProcedureById(Long id);

    Procedures updateProcedure(Procedures procedimiento);

    void deleteProcedureById(Long id);

}
