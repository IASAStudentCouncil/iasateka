package ua.iasasc.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import ua.iasasc.clients.EmailVerificationClient;
import ua.iasasc.models.VerificationLink;
import ua.iasasc.services.EmailService;
import ua.iasasc.services.VerificationLinkService;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final MailSender mailSender;
    private final VerificationLinkService verificationLinkService;
    private final EmailVerificationClient emailVerificationClient;

    @Override
    public void sendEmail(SimpleMailMessage message) {
        mailSender.send(message);
    }

    @Override
    public void verifyEmailByCipher(String cipher){
        VerificationLink verificationLink = verificationLinkService.findByCipher(cipher);


    }
}
