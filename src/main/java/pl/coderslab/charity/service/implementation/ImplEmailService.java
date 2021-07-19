package pl.coderslab.charity.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import pl.coderslab.charity.service.EmailService;


@Component
public class ImplEmailService implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public ImplEmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMessage(String name, String surname, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("to@gmail.com");
        message.setSubject("Wiadomość od " + name + surname + "ze strony CharityDonation");
        message.setText(text);
        System.out.println("Message send");
        emailSender.send(message);
    }
}
