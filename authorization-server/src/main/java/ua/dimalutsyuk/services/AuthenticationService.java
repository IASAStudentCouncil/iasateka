package ua.dimalutsyuk.services;

import ua.dimalutsyuk.payload.requests.LoginRequest;
import ua.dimalutsyuk.payload.requests.RegistrationRequest;

public interface AuthenticationService {
    String registerNewUser(RegistrationRequest registrationRequest);

    String loginUser(LoginRequest loginRequest);
}
