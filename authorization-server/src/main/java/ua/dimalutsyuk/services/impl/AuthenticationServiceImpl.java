package ua.dimalutsyuk.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.dimalutsyuk.exceptions.AuthenticationException;
import ua.dimalutsyuk.models.Credentials;
import ua.dimalutsyuk.payload.requests.LoginRequest;
import ua.dimalutsyuk.payload.requests.RegistrationRequest;
import ua.dimalutsyuk.services.AuthenticationService;
import ua.dimalutsyuk.services.CredentialsService;
import ua.dimalutsyuk.services.JwtService;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final CredentialsService credentialsService;
    private final JwtService jwtService;

    @Override
    public String registerNewUser(RegistrationRequest registrationRequest) {
        credentialsService.saveCredentials(new Credentials(
                registrationRequest.email(),
                passwordEncoder.encode(registrationRequest.password()),
                registrationRequest.telegramUsername()));
        return jwtService
                .generateTokenByEmail(registrationRequest.email());
    }

    @Override
    public String loginUser(LoginRequest loginRequest) {
        Credentials credentials = credentialsService.findByEmail(loginRequest.email());
        if (!passwordEncoder.matches(loginRequest.password(), credentials.getPassword())) {
            throw new AuthenticationException("Credentials does not match one in database");
        }
        return jwtService
                .generateTokenByEmail(loginRequest.email());
    }
}
