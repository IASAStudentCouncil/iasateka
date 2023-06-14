package ua.iasasc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;
import ua.iasasc.payload.requests.EmailVerificationRequest;
import ua.iasasc.services.CodeService;
import ua.iasasc.services.EmailMessageService;
import ua.iasasc.services.EmailService;
import ua.iasasc.services.VerificationLinkService;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    private final CodeService codeService;
    private final EmailMessageService emailMessageService;
    private final VerificationLinkService linkService;

    @PostMapping("/code")
    public ResponseEntity<Void> sendCodeEmail(@RequestBody EmailVerificationRequest request) {
        SimpleMailMessage emailMessage = emailMessageService
                .generateCodeMessage(codeService.generateCode(), request.email());
        emailService.sendEmail(emailMessage);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify")
    public ResponseEntity<Void> sendVerificationLink(@RequestBody EmailVerificationRequest request) {
        SimpleMailMessage emailMessage = emailMessageService
                .generateVerificationLinkMessage(linkService
                        .generateAndRecordVerificationLink(request.email()), request.email());
        emailService.sendEmail(emailMessage);
        return ResponseEntity.ok().build();
    }

    /*
    Request param name of this method must be equal one in the application.yml (verification-link-param-name)
     */
    @GetMapping("/verify")
    public ResponseEntity<Void> verifyEmail(@RequestParam("cipher") String requestParam) {
        emailService.verifyEmailByCipher(requestParam);
        return ResponseEntity.ok().build();
    }
}
