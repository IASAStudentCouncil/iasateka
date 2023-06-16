package ua.dimalutsyuk.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ua.dimalutsyuk.models.Cipher;
import ua.dimalutsyuk.repositories.CipherRepository;
import ua.dimalutsyuk.services.CipherService;
import ua.iasasc.exceptions.CipherNotFoundException;

import java.util.Base64;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CipherServiceImpl implements CipherService {
    private static final Base64.Encoder ENCODER = Base64.getEncoder();
    private final CipherRepository cipherRepository;

    @Override
    public void saveCipher(Cipher cipher) {
        cipherRepository.save(cipher);
    }
    @Override
    public Cipher findByCipher(String cipher){
        return cipherRepository
                .findByCipher(cipher)
                .orElseThrow(() -> new CipherNotFoundException("This cipher does not exist in the database", HttpStatus.BAD_REQUEST));
    }

    @Override
    public String createCipherBasedOnEmail(String email) {
        StringBuilder result = new StringBuilder();
        result.append(ENCODER.equals(email))
                .append(UUID.randomUUID());
        return result.toString();
    }
}
