package net.javaguides.springboot.web;

import net.javaguides.springboot.model.*;
import net.javaguides.springboot.service.AppointmentService;
import net.javaguides.springboot.service.ConsultaService;
import net.javaguides.springboot.service.EnfermedadService;
import net.javaguides.springboot.service.ProcedureService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ConsutaController {
    private ConsultaService consultaService;
    private AppointmentService appointmentService;

    private EnfermedadService enfermedadService;

    private ProcedureService procedureService;
    private User usuarioActivo;

    public ConsutaController(ConsultaService consultaService, AppointmentService appointmentService, EnfermedadService enfermedadService,ProcedureService procedureService) {
        super();
        this.consultaService = consultaService;
        this.appointmentService = appointmentService;
        this.enfermedadService = enfermedadService;
        this.procedureService = procedureService;
    }

    private long getUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.getPrincipal();
        System.out.println(authentication.getPrincipal());
        return 1;
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
        consulta.setIdCita(0);
        prueba();
        List<Procedures> procedures = procedureService.getAllProcedures();
        List<Enfermedad> enfermedades = enfermedadService.getAllEnfermedades();
        model.addAttribute("procedimientos",procedures);
        model.addAttribute("enfermedades",enfermedades);
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
        consulta.setDate(cita.getDate());
        consulta.setIdDoctor(cita.getDoctorID());
        List<Procedures> procedures = procedureService.getAllProcedures();
        List<Enfermedad> enfermedades = enfermedadService.getAllEnfermedades();

        model.addAttribute("procedimientos",procedures);
        model.addAttribute("enfermedades",enfermedades);
        model.addAttribute("consulta",consulta);

        return "registrarConsulta";
    }


    @PostMapping("/consultas/registrar")
    public String registraConsulta(@ModelAttribute("consulta") Consulta consulta,WebRequest request){
        consulta.setIdDoctor(getUserId());
        consulta.setDate(LocalDate.now());
        String[] procedimientos = request.getParameterValues("procedimientos");
        String[] enfermedades =  request.getParameterValues("enfermedades");

        consulta.setProcedimientos(getProcedimientos(procedimientos));
        consulta.setCost(calcularCostos(consulta.getProcedimientos(enfermedades)));

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

    @GetMapping("/consultas/ver/{id}")
    public String verConsulta(@PathVariable long id, Model model){
        Consulta consulta = consultaService.getConsultaById(id);
        model.addAttribute("consulta",consulta);
        return "verConsulta";
    }

    @GetMapping("/consultas/eliminar/{id}")
    public String eliminarConsulta(@PathVariable long id){
        consultaService.deleteConsultaById(id);

        return "redirect:/consultas";

    }

    private void prueba(){
        for (int i = 0; i < 10; i++){
            Enfermedad aux = new Enfermedad(i,"Enfermedad" + i);
            enfermedadService.saveEnfermedad(aux);

            Procedures pros = new Procedures(i,"Procedimiento" + i,i * 5);
            procedureService.saveProcedure(pros);
        }
    }
    private List<Procedures> getProcedimientos(String[] procedimientos) {
        List<Procedures> procedures = new ArrayList<Procedures>();
        for (String procedimiento:procedimientos) {
            long id = Long.parseLong(procedimiento);
            procedures.add(procedureService.getProcedureById(id));
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

    private List<Enfermedad> getEnfermedades(String[] enfermedades) {
        List<Enfermedad> enfermedads = new ArrayList<Enfermedad>();
        for (String procedimiento:enfermedades) {
            long id = Long.parseLong(procedimiento);
            enfermedads.add(enfermedadService.getEnfermedadByIcd(id));
        }
        return enfermedads;
    }
}
