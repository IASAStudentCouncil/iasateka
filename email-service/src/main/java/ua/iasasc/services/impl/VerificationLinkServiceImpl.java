package ua.iasasc.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.iasasc.excpetions.LinkNotFoundException;
import ua.iasasc.models.VerificationLink;
import ua.iasasc.repositories.VerificationLinkRepository;
import ua.iasasc.services.VerificationLinkService;

import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VerificationLinkServiceImpl implements VerificationLinkService {
    private static final String DOMAIN = "http://babusia.com";
    private static final String PATH = "/verify";
    private final Base64.Encoder encoder = Base64.getEncoder();
    private final VerificationLinkRepository repository;
    @Value("${verification-link-param-name}")
    private String verificationLinkParamName;

    @Override
    public VerificationLink saveVerificationLink(VerificationLink verificationLink) {
        verificationLink = repository.save(verificationLink);
        return verificationLink;
    }

    @Override
    public String generateAndRecordVerificationLink(String email) {
        String cipher = encoder.encodeToString(email.getBytes()) + UUID.randomUUID();
        String link = String
                .format("%s%s?%s=%s",
                        DOMAIN,
                        PATH,
                        verificationLinkParamName,
                        cipher);
        saveVerificationLink(new VerificationLink(link, email, cipher));
        return link;
    }

    @Override
    public VerificationLink findByCipher(String cipher) {
        return repository
                .findByCipher(cipher)
                .orElseThrow(() -> new LinkNotFoundException("No such link in database", HttpStatus.BAD_REQUEST));
    }
}
