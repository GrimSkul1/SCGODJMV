package net.javaguides.springboot.controller;

import net.javaguides.springboot.entity.Paciente;
import net.javaguides.springboot.service.PacienteService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        super();
        this.pacienteService = pacienteService;
    }

    @GetMapping("/paciente")
    public String listPacientes(Model model){
        model.addAttribute("pacientes",pacienteService.getAllPacientes());
        return "pacientes";

    }

    @GetMapping("/paciente/new")
    public String createPacienteForm(Model model){

        Paciente paciente = new Paciente();
        model.addAttribute("paciente",paciente);
        return "crear_paciente";
    }

    @PostMapping("/paciente")
    public String savePaciente(@ModelAttribute("paciente") Paciente paciente){
        pacienteService.savePaciente(paciente);
        return "redirect:/paciente";
    }

    @GetMapping("/paciente/edit/{id}")
    public String editPacienteForm(@PathVariable Long id, Model model){
        model.addAttribute("paciente",pacienteService.getPacienteById(id));
        return "edit_paciente";
    }

    @PostMapping("/paciente/{id}")
    public String updatePaciente(@PathVariable Long id,
                                @ModelAttribute("paciente") Paciente paciente,
                                Model model) {

        Paciente existingPaciente = pacienteService.getPacienteById(id);
        existingPaciente.setId(id);
        existingPaciente.setNombre(paciente.getNombre());
        existingPaciente.setApellido(paciente.getApellido());
        existingPaciente.setEmail(paciente.getEmail());
        existingPaciente.setNumero(paciente.getNumero());
        existingPaciente.setDireccion(paciente.getDireccion());
        existingPaciente.setIdentificacion(paciente.getIdentificacion());
        existingPaciente.setSeguro(paciente.getSeguro());
        existingPaciente.setFechaNacimiento(paciente.getFechaNacimiento());
        existingPaciente.setNombreContacto(paciente.getNombreContacto());
        existingPaciente.setNumeroContacto(paciente.getNumeroContacto());
        existingPaciente.setEstadoCivil(paciente.getEstadoCivil());
        existingPaciente.setProfesion(paciente.getProfesion());
        existingPaciente.setNacionalidad(paciente.getNacionalidad());


        pacienteService.updatePaciente(existingPaciente);
        return "redirect:/paciente";
    }

    @GetMapping("/paciente/{id}")
    public String DeletePaciente (@PathVariable Long id) {
        pacienteService.deletePacientebyId(id);
        return "redirect:/paciente";
    }
}
