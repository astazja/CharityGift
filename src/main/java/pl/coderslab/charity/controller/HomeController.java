package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;


@Controller
@RequiredArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final UserService userService;

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.allInstitutions());
        model.addAttribute("bags", donationService.getQuantityOfBags());
        model.addAttribute("donations", donationService.countDonations());
        return "index";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String save(@RequestParam String repeat, @Valid User user, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "register";
        }
        if(userService.findByUserEmail(user.getEmail()) != null) {
            model.addAttribute("emailMessage", "Taki email już istnieje");
            return "register";
        }
        if(!user.getPassword().equals(repeat)){
            result.addError(new FieldError("user","password","Podane hasła, nie są takie same"));
            return "register";
        }
        userService.saveUser(user);
        return "login";
    }
}
