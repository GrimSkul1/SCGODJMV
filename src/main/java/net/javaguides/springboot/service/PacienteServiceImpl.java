package net.javaguides.springboot.service;

import net.javaguides.springboot.entity.Paciente;
import net.javaguides.springboot.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        super();
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public List<Paciente> getAllPacientes(){
        return pacienteRepository.findAll();
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente getPacienteById(Long id) {
        return pacienteRepository.findById(id).get();
    }

    @Override
    public Paciente updatePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletePacientebyId(Long id) {
        pacienteRepository.deleteById(id);
    }
}
