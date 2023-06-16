package ua.dimalutsyuk.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.dimalutsyuk.models.Cipher;
import ua.dimalutsyuk.services.CipherService;
import ua.dimalutsyuk.services.CredentialsService;
import ua.dimalutsyuk.services.VerificationLinkService;
import ua.iasasc.payload.responses.VerificationLinkResponse;

@RestController
@RequestMapping("/verify")
@RequiredArgsConstructor
public class VerificationController {
    private final CredentialsService credentialsService;
    private final VerificationLinkService verificationLinkService;
    private final CipherService cipherService;

    @GetMapping("/email")
    public ResponseEntity<Void> verifyEmail(@RequestParam("cipher") String emailCipher) {
        String email = cipherService.findByCipher(emailCipher).getEmail();
        credentialsService.setEmailToVerified(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/link")
    public ResponseEntity<VerificationLinkResponse> getVerificationLink(@RequestParam("email") String email) {
        String cipher = cipherService.createCipherBasedOnEmail(email);
        cipherService.saveCipher(new Cipher(cipher, email));
        String verificationLink = verificationLinkService.getVerificationLink(cipher);
        return new ResponseEntity<>(new VerificationLinkResponse(email, verificationLink), HttpStatus.OK);
    }
}
