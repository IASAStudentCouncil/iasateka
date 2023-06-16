package ua.dimalutsyuk.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.dimalutsyuk.services.VerificationLinkService;

@Service
@RequiredArgsConstructor
public class VerificationLinkServiceImpl implements VerificationLinkService {
    private static final String DOMAIN = "http://babusia.com";
    private static final String PATH = "/api/verify/email";

    @Override
    public String getVerificationLink(String cipher) {
        return String.format("%s%s?cipher=%s", DOMAIN, PATH, cipher);
    }
}
