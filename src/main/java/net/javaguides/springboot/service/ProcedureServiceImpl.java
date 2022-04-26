package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Procedures;
import net.javaguides.springboot.repository.ProcedureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedureServiceImpl implements ProcedureService{

    private ProcedureRepository procedureRepository;

    public ProcedureServiceImpl(ProcedureRepository procedureRepository) {
        super();
        this.procedureRepository = procedureRepository;
    }

    @Override
    public List<Procedures> getAllProcedures() {
        return procedureRepository.findAll();
    }

    @Override
    public Procedures saveProcedure(Procedures procedimiento) {
        return procedureRepository.save(procedimiento);
    }

    @Override
    public Procedures getProcedureById(Long id) {
        return procedureRepository.getProceduresById(id);
    }

    @Override
    public Procedures updateProcedure(Procedures procedimiento) {
        return procedureRepository.save(procedimiento);
    }

    @Override
    public void deleteProcedureById(Long id) {
        procedureRepository.deleteById(id);
    }
}
