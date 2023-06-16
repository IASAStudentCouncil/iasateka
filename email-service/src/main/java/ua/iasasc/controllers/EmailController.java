package ua.iasasc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iasasc.payload.requests.EmailCodeRequest;
import ua.iasasc.payload.requests.EmailLinkRequest;
import ua.iasasc.services.EmailMessageService;
import ua.iasasc.services.EmailService;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    private final EmailMessageService emailMessageService;

    @PostMapping("/code")
    public ResponseEntity<Void> sendCodeEmail(@RequestBody EmailCodeRequest request) {
        SimpleMailMessage emailMessage = emailMessageService
                .generateCodeMessage(request.code(), request.email());
        emailService.sendEmail(emailMessage);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify")
    public ResponseEntity<Void> sendVerificationLink(@RequestBody EmailLinkRequest request) {
        SimpleMailMessage emailMessage = emailMessageService
                .generateVerificationLinkMessage(request.link(), request.email());
        emailService.sendEmail(emailMessage);
        return ResponseEntity.ok().build();
    }
}
