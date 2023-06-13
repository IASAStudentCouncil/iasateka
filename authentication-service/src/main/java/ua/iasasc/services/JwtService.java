package ua.iasasc.services;

public interface JwtService {
    String generateTokenByEmail(String email);

    void verifyToken(String token, String email);
}
