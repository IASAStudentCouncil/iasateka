package ua.dimalutsyuk.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.iasasc.exceptions.AuthenticationException;
import ua.dimalutsyuk.models.Credentials;
import ua.iasasc.payload.requests.LoginRequest;
import ua.iasasc.payload.requests.RegistrationRequest;
import ua.dimalutsyuk.services.AuthenticationService;
import ua.dimalutsyuk.services.CredentialsService;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final CredentialsService credentialsService;

    @Override
    public void registerNewUser(RegistrationRequest registrationRequest) {
        credentialsService.saveCredentials(new Credentials(
                registrationRequest.email(),
                passwordEncoder.encode(registrationRequest.password()),
                registrationRequest.telegramUsername()));
    }

    @Override
    public void loginUser(LoginRequest loginRequest) {
        Credentials credentials = credentialsService.findByEmail(loginRequest.email());
        if (!passwordEncoder.matches(loginRequest.password(), credentials.getPassword())) {
            throw new AuthenticationException("Credentials does not match one in database");
        }
    }
}
