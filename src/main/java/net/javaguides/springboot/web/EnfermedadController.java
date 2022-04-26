package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Enfermedad;
import net.javaguides.springboot.service.EnfermedadService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EnfermedadController {
    private EnfermedadService enfermedadService;

    public EnfermedadController(EnfermedadService enfermedadService) {
        super();
        this.enfermedadService = enfermedadService;
    }

    @GetMapping("/enfermedad")
    public String listEnfermedad(Model model) {
        model.addAttribute("enfermedades", enfermedadService.getAllEnfermedades());
        return "enfermedades";
    }

    @GetMapping("/enfermedad/nueva")
    public String createProcedureForm(Model model) {
        // create procedure object to hold appointment form data
        Enfermedad enfermedades = new Enfermedad();
        model.addAttribute("enfermedades", enfermedades);
        return "crear_enfermedad";
    }

    @PostMapping("/enfermedad")
    public String saveProcedure(@ModelAttribute("enfermedades") Enfermedad enfermedades) {
        enfermedadService.saveEnfermedad(enfermedades);
        return "redirect:/enfermedad";
    }

    // handler method to handle delete sickness request

    @GetMapping("/enfermedad/{id}")
    public String deleteProcedure(@PathVariable Long id) {
        enfermedadService.deleteEnfermedadByIcd(id);
        return "redirect:/enfermedad";
    }
}
