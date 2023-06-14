package ua.iasasc.services;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendEmail(SimpleMailMessage message);

    void verifyEmailByCipher(String cipher);
}