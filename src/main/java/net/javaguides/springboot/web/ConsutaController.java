package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Appointment;
import net.javaguides.springboot.model.Consulta;
import net.javaguides.springboot.model.Procedures;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.AppointmentService;
import net.javaguides.springboot.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ConsutaController {
    private ConsultaService consultaService;
    private AppointmentService appointmentService;
    private User usuarioActivo;
    private long getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User)authentication.getPrincipal();
        return user.getId();
    }
    @GetMapping("/consultas")
    public String listConsultas(Model model){
        List<Consulta> consultas = consultaService.getConsultasByIdDoctor(getUserId());
        model.addAttribute("consultas", consultas);
        return "consultas";
    }

    @GetMapping("/consultas/paciente/{id}")
    public String listConsultasPorPaciente(Model model,@PathVariable Long id){
        if (id != null) {
            List<Consulta> consultas = consultaService.getConsultasByIdPaciente(id);
            model.addAttribute("consultas", consultas);

        }else {
            List<Consulta> consultas = consultaService.getConsultasByIdDoctor(getUserId());
            model.addAttribute("consultas", consultas);
            model.addAttribute("error","No existen consultas para dicho paciente");
        }

        return "consultas";
    }

    @GetMapping("/consultas/registrar/nueva")
    public String crearConsultaDesdeCero(Model model){
        Consulta consulta = new Consulta();
        model.addAttribute("consulta",consulta);
        return "registrarConsulta";
    }

    @GetMapping("/consultas/registrar/{id}")
    public String creacConsultaFromCita(@PathVariable long id, Model model){
        Appointment cita = appointmentService.getAppointmentById(id);
        Consulta consulta = new Consulta();
        consulta.setIdCita(cita.getId());
        consulta.setIdPaciente(cita.getPacientID());
        consulta.setTime(cita.getTime());
        consulta.setIdDoctor(cita.getDoctorID());

        model.addAttribute("consulta",consulta);
        return "registrarConsulta";
    }


    @PostMapping("/consultas/registrar")
    public String registraConsulta(@ModelAttribute("consulta") Consulta consulta){
        consulta.setIdDoctor(getUserId());
        consulta.setDate(LocalDate.now());
        consulta.setProcedimientos(getProcedimientos(null));
        consulta.setCost(calcularCostos(consulta.getProcedimientos()));

        consultaService.saveConsulta(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/consultas/edit/{id}")
    public String editarConsulta(@PathVariable long id, Model model){
        model.addAttribute("consulta",consultaService.getConsultaById(id));
        return "editConsulta";
    }

    @PostMapping("/consultas/{id}")
    public String actualizarConsulta(@PathVariable long id, @ModelAttribute("consulta") Consulta consulta, Model model){
        consulta.setId(id);
        consultaService.updateConsulta(consulta);

        return "redirect:/consultas";
    }

    private List<Procedures> getProcedimientos(List<String> procedimientos) {
        List<Procedures> procedures = new ArrayList<Procedures>();
        for (String procedimiento:procedimientos) {
            //Buscar el procedimiento usando el servicio y agregarlo a procedures
        }
        return procedures;
    }

    private float calcularCostos(List<Procedures> procedimientos){
        float total = 0;
        for (Procedures procedimiento: procedimientos) {
            total += procedimiento.getCosto();
        }
        return total;
    }
}
