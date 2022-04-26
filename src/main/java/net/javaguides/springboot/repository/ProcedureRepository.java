package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Procedures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository()
public interface ProcedureRepository extends JpaRepository<Procedures, Long> {
    Procedures getProceduresById(long id);
}
