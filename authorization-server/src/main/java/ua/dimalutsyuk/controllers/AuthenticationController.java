package ua.dimalutsyuk.controllers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iasasc.payload.requests.LoginRequest;
import ua.iasasc.payload.requests.RegistrationRequest;
import ua.dimalutsyuk.services.AuthenticationService;
import ua.dimalutsyuk.services.CookieService;
import ua.dimalutsyuk.services.TokenService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final CookieService cookieService;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegistrationRequest registrationRequest, HttpServletResponse response) {
        authenticationService.registerNewUser(registrationRequest);
        String jwtToken = tokenService.issueToken(registrationRequest.email());
        response.addCookie(cookieService.generateJwtCookie(jwtToken));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody LoginRequest loginRequest, HttpServletResponse httpServletResponse) {
        authenticationService.loginUser(loginRequest);
        String jwtToken = tokenService.issueToken(loginRequest.email());
        httpServletResponse.addCookie(cookieService.generateJwtCookie(jwtToken));
        return ResponseEntity.ok().build();
    }
}
