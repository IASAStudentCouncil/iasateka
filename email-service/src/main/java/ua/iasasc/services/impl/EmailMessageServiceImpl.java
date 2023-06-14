package ua.iasasc.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ua.iasasc.services.EmailMessageService;

@Service
@RequiredArgsConstructor
public class EmailMessageServiceImpl implements EmailMessageService {
    private static final String FROM = "higuanda.john@gmail.com";

    @Override
    public SimpleMailMessage generateCodeMessage(String code, String email) {
        String subject = "Password recovery";
        String text = String
                .format("To recover your password please enter the code: %s in the form on the site!", code);
        return fillSimpleMailMessage(FROM, email, subject, text);
    }


    @Override
    public SimpleMailMessage generateVerificationLinkMessage(String verificationLink, String email) {
        String subject = "Email verification";
        String text = String
                .format("To verify your email, please follow the link: %s", verificationLink);
        return fillSimpleMailMessage(FROM, email, subject, text);
    }

    private SimpleMailMessage fillSimpleMailMessage(String from, String to, String subject, String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        return mailMessage;
    }
}
