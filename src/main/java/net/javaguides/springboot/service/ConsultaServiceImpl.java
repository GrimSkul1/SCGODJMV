package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Consulta;
import net.javaguides.springboot.repository.ConsultaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ConsultaServiceImpl implements ConsultaService{

    private ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        super();
        this.consultaRepository = consultaRepository;
    }

    @Override
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public List<Consulta> getConsultasByIdDoctor(long idDoctor) {
        return consultaRepository.getConsultasByIdDoctor(idDoctor);
    }

    @Override
    public List<Consulta> getConsultasByIdPaciente(long idPaciente) {
        return consultaRepository.getConsultasByIdPaciente(idPaciente);
    }

    @Override
    public Consulta saveConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public Consulta getConsultaById(long id) {
        return consultaRepository.findById(id).get();
    }

    @Override
    public Consulta updateConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }

    @Override
    public void deleteConsultaById(long id) {
        consultaRepository.deleteById(id);
    }
}
