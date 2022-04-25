package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Consulta;

import java.util.List;

public interface ConsultaService {
    List<Consulta> getAllConsultas();

    List<Consulta> getConsultasByIdDoctor(long idDoctor);

    List<Consulta> getConsultasByIdPaciente(long idPaciente);
    Consulta saveConsulta(Consulta consulta);

    Consulta getConsultaById(long id);

    Consulta updateConsulta(Consulta consulta);

    void deleteConsultaById(long id);


}
