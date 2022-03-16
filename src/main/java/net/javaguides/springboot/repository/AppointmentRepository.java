package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}