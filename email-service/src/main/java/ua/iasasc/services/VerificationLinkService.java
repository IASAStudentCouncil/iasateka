package ua.iasasc.services;

import ua.iasasc.models.VerificationLink;

public interface VerificationLinkService {
    VerificationLink saveVerificationLink(VerificationLink verificationLink);

    String generateAndRecordVerificationLink(String email);

    VerificationLink findByCipher(String cipher);
}
