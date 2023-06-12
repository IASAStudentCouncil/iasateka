package ua.dimalutsyuk.controllers;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.dimalutsyuk.payload.requests.LoginRequest;
import ua.dimalutsyuk.payload.requests.RegistrationRequest;
import ua.dimalutsyuk.services.AuthenticationService;
import ua.dimalutsyuk.services.CookieService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final CookieService cookieService;

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody RegistrationRequest registrationRequest, HttpServletResponse response) {
        String jwtToken = authenticationService.registerNewUser(registrationRequest);
        response.addCookie(cookieService.generateJwtCookie(jwtToken));
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Void> loginUser(@RequestBody LoginRequest loginRequest, HttpServletResponse httpServletResponse) {
        String jwtToken = authenticationService.loginUser(loginRequest);
        httpServletResponse.addCookie(cookieService.generateJwtCookie(jwtToken));
        return ResponseEntity.ok().build();
    }
}
