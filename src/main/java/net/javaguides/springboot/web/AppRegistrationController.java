package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Appointment;
import net.javaguides.springboot.service.AppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppRegistrationController {
    private AppointmentService appointmentService;

    public AppRegistrationController(AppointmentService appointmentService) {
        super();
        this.appointmentService = appointmentService;
    }

    // handler method to handle list appointmens and return mode and view
    @GetMapping("/citas")
    public String listAppointments(Model model) {
        model.addAttribute("citas", appointmentService.getAllAppointments());
        return "citas";
    }

    @GetMapping("/citas/nueva")
    public String createAppointmentForm(Model model) {
        // create appointment object to hold appointment form data
        Appointment appointment = new Appointment();
        model.addAttribute("cita", appointment);
        return "create_appointment";
    }

    @PostMapping("/citas")
    public String saveAppointment(@ModelAttribute("student") Appointment appointment) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/citas";
    }

    @GetMapping("/edit/{id}")
    public String editAppointmentForm(@PathVariable Long id, Model model) {
        model.addAttribute("cita", appointmentService.getAppointmentById(id));
        return "edit_appointment";
    }

    @PostMapping("/{id}")
    public String updateAppointment(@PathVariable Long id,
                                    @ModelAttribute("cita") Appointment appointment,
                                    Model model) {

        // get student from database by id
        Appointment existingAppointment = appointmentService.getAppointmentById(id);
        existingAppointment.setDate(appointment.getDate());
        existingAppointment.setTime(appointment.getTime());
        existingAppointment.setDescription(appointment.getDescription());

        // save updated student object
        appointmentService.updateAppointment(existingAppointment);
        return "redirect:/citas";
    }

    // handler method to handle delete student request

    @GetMapping("/{id}")
    public String deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
        return "redirect:/citas";
    }
}