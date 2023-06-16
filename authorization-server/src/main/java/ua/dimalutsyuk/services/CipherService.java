package ua.dimalutsyuk.services;

import ua.dimalutsyuk.models.Cipher;

public interface CipherService {
    void saveCipher(Cipher cipher);

    String createCipherBasedOnEmail(String email);
    Cipher findByCipher(String cipher);
}
