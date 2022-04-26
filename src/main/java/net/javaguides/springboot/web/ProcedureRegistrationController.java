package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Procedures;
import net.javaguides.springboot.service.ProcedureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProcedureRegistrationController {
    private ProcedureService procedureService;

    public ProcedureRegistrationController(ProcedureService procedureService) {
        super();
        this.procedureService = procedureService;
    }

    @GetMapping("/procedimiento")
    public String listProcedures(Model model) {
        model.addAttribute("procedimiento", procedureService.getAllProcedures());
        return "procedimiento";
    }

    @GetMapping("/procedimiento/nuevo")
    public String createProcedureForm(Model model) {
        // create procedure object to hold appointment form data
        Procedures procedures = new Procedures();
        model.addAttribute("procedimiento", procedures);
        return "crear_procedimiento";
    }

    @PostMapping("/procedimiento")
    public String saveProcedure(@ModelAttribute("procedimiento") Procedures procedures) {
        procedureService.saveProcedure(procedures);
        return "redirect:/procedimiento";
    }

    // handler method to handle delete procedure request

    @GetMapping("/procedimiento/{id}")
    public String deleteProcedure(@PathVariable Long id) {
        procedureService.deleteProcedureById(id);
        return "redirect:/procedimiento";
    }

}
