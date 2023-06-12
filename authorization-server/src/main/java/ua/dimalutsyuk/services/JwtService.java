package ua.dimalutsyuk.services;

public interface JwtService {
    String generateTokenByEmail(String email);
}
