package pl.coderslab.charity.service;

public interface EmailService {
    void sendMessage(String name, String surname, String text);
}
