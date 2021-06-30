package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.List;

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
    @GetMapping("/institution/edit/{id}")
    public String editInstitution(Model model, @PathVariable Long id) {
        model.addAttribute("institution", institutionService.getInstitution(id));
        return "admin/editInstitution";
    }
    @PostMapping("/update")
    public String updateInstitution(@Valid Institution institution, BindingResult result) {
        if(result.hasErrors()) {
            return "/admin/editInstitution";
        }
        institutionService.updateInstitution(institution);
        return "redirect:/admin/institutions";
    }
    @GetMapping("/institution/delete/{id}")
    public String deleteInstitution(@PathVariable Long id) {
        institutionService.removeInstitution(id);
        return "redirect:/admin/institutions";
    }
    @GetMapping("/admins")
    public String showAdmins(Model model) {
        List<User> admins = userService.findUsersByRole("ROLE_ADMIN");
        model.addAttribute("admins", admins);
        return "admin/admins";
    }
    @GetMapping("/add")
    public String addAdmin(Model model) {
        model.addAttribute("admin", new User());
        return "admin/add";
    }
    @PostMapping("/add")
    public String saveAdmin(@Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "/admin/add";
        }
        if(userService.findByUserEmail(user.getEmail()) != null) {
            model.addAttribute("emailMessage", "Taki email już istnieje");
            return "/admin/add";
        }
        userService.saveAdmin(user);
        return "redirect:/admin/admins";
    }
    @GetMapping("/edit/{id}")
    public String editAdmin(Model model, @PathVariable Long id) {
        model.addAttribute("admin", userService.getUserById(id));
        return "admin/edit";
    }
    @PostMapping("/updateAdmin")
    public String updateAdmin(@Valid User user, BindingResult result,
                              @RequestParam String password) {
        if(result.hasErrors()) {
            return "/admin/edit";
        }
        userService.editAdmin(user, password);
        return "redirect:/admin/admins";
    }
    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        userService.removeUser(id);
        return "redirect:/admin/admins";
    }
    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = userService.findUsersByRole("ROLE_USER");
        model.addAttribute("users", users);
        return "admin/users";
    }
    @GetMapping("/editUser/{id}")
    public String editUser(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "admin/editUser";
    }
    @PostMapping("/updateUser")
    public String updateUser(@Valid User user, BindingResult result,
                              @RequestParam String password) {
        if(result.hasErrors()) {
            return "/admin/editUser";
        }
        userService.editAdmin(user, password);
        return "redirect:/admin/users";
    }
    @RequestMapping("/enableUser/{id}")
    public String enableUser(@PathVariable Long id) {
        userService.enableUser(userService.getUserById(id));
        return "redirect:/admin/users";
    }
    @RequestMapping("/disableUser/{id}")
    public String disableUser(@PathVariable Long id) {
        userService.disableUser(userService.getUserById(id));
        return "redirect:/admin/users";
    }
}
