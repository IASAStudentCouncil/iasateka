package ua.dimalutsyuk.services;

import ua.iasasc.payload.requests.LoginRequest;
import ua.iasasc.payload.requests.RegistrationRequest;

public interface AuthenticationService {
    void registerNewUser(RegistrationRequest registrationRequest);

    void loginUser(LoginRequest loginRequest);
}
