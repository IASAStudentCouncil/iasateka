package ua.dimalutsyuk.services;

public interface CodeService {
    String generateCode();

    void verifyCode(String email, String code);

    void saveCode(String email, String code);
}
