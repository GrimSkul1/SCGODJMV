package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Enfermedad;
import net.javaguides.springboot.repository.EnfermedadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfermedadServiceImpl implements EnfermedadService {
    private EnfermedadRepository enfermedadRepository;

    public EnfermedadServiceImpl(EnfermedadRepository enfermedadRepository) {
        super();
        this.enfermedadRepository = enfermedadRepository;
    }

    @Override
    public List<Enfermedad> getAllEnfermedades() {
        return enfermedadRepository.findAll();
    }

    @Override
    public Enfermedad saveEnfermedad(Enfermedad enfermedad) {
        return enfermedadRepository.save(enfermedad);
    }

    @Override
    public Enfermedad getEnfermedadByIcd(Long id) {
        return enfermedadRepository.getEnfermedadByIcd(id);
    }

    @Override
    public Enfermedad updateProcedure(Enfermedad enfermedad) {
        return enfermedadRepository.save(enfermedad);
    }

    @Override
    public void deleteEnfermedadByIcd(Long id) {
        enfermedadRepository.deleteById(id);
    }
}
