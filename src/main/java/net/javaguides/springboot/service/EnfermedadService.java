package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Enfermedad;
import net.javaguides.springboot.model.Procedures;

import java.util.List;

public interface EnfermedadService {
    List<Enfermedad> getAllEnfermedades();

    Enfermedad saveEnfermedad(Enfermedad enfermedad);

    Enfermedad getEnfermedadByIcd(Long id);

    Enfermedad updateProcedure(Enfermedad enfermedad);

    void deleteEnfermedadByIcd(Long id);}
