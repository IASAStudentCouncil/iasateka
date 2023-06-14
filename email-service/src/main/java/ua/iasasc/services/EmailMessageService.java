package ua.iasasc.services;

import org.springframework.mail.SimpleMailMessage;

public interface EmailMessageService {
    SimpleMailMessage generateCodeMessage(String code, String email);

    SimpleMailMessage generateVerificationLinkMessage(String verificationLink, String email);
}
