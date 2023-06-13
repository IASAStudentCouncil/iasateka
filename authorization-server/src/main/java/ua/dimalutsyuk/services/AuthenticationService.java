package ua.dimalutsyuk.services;

import ua.dimalutsyuk.payload.requests.LoginRequest;
import ua.dimalutsyuk.payload.requests.RegistrationRequest;

public interface AuthenticationService {
    void registerNewUser(RegistrationRequest registrationRequest);

    void loginUser(LoginRequest loginRequest);
}
