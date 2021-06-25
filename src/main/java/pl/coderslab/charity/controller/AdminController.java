package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

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
    @GetMapping("/institution")
    public String showInstitutions(Model model) {
        model.addAttribute("institutions", institutionService.allInstitutions());
        return "admin/institutions";
    }
}
