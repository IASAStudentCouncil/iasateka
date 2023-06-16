package ua.iasasc.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ua.iasasc.services.EmailService;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final MailSender mailSender;

    @Override
    public void sendEmail(SimpleMailMessage message) {
        mailSender.send(message);
    }
}
