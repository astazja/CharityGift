package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final InstitutionService institutionService;
    private final UserService userService;

    @GetMapping()
    public String adminPage() {
        return "admin/admin";
    }
    @GetMapping("/institutions")
    public String showInstitutions(Model model) {
        model.addAttribute("institutions", institutionService.allInstitutions());
        return "admin/institutions";
    }
    @GetMapping("/addInstitution")
    public String addInstitution(Model model) {
        model.addAttribute("institution", new Institution());
        return "admin/addInstitution";
    }
    @PostMapping("/addInstitution")
    public String saveInstitution(@Valid Institution institution, BindingResult result) {
        if(result.hasErrors()) {
            return "/admin/addInstitution";
        }
        institutionService.addInstitution(institution);
        return "redirect:/admin/institutions";
    }
}
