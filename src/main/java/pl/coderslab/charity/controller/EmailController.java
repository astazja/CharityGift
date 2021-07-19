package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.service.EmailService;

@Controller
public class EmailController {
    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/emailContact")
    public String emailSender(@RequestParam String name, @RequestParam String surname,
                              @RequestParam String message, Model model) {
        if(!message.equals("")) {
            emailService.sendMessage(name, surname, message);
            model.addAttribute("message", "Dziękujemy za wiadomość");
        }else{
            model.addAttribute("message", "Nie udało sie wysłać wiadomości");
        }
        return "index";
    }
}
