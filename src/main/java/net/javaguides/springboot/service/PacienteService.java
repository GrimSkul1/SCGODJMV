package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Paciente;

import java.util.List;

public interface PacienteService {

    List<Paciente> getAllPacientes();

    Paciente savePaciente(Paciente paciente);

    Paciente getPacienteById(Long id);

    Paciente updatePaciente(Paciente paciente);

    void deletePacientebyId(Long id);

}
