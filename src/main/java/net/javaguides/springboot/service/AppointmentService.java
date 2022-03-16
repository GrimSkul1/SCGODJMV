package net.javaguides.springboot.service;

import net.javaguides.springboot.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();

    Appointment saveAppointment(Appointment appointment);

    Appointment getAppointmentById(Long id);

    Appointment updateAppointment(Appointment appointment);

    void deleteAppointmentById(Long id);
}
