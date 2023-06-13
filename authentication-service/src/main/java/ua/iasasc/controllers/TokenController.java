package ua.iasasc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.iasasc.payload.requests.TokenIssuingRequest;
import ua.iasasc.payload.requests.TokenVerificationRequest;
import ua.iasasc.payload.responses.TokenResponse;
import ua.iasasc.services.JwtService;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {
    private final JwtService jwtService;

    @PostMapping("/issue")
    public ResponseEntity<TokenResponse> issueToken(@RequestBody TokenIssuingRequest request) {
        String token = jwtService.generateTokenByEmail(request.getEmail());
        return new ResponseEntity<>(
                new TokenResponse(request.getEmail(), token),
                HttpStatus.OK
        );
    }

    @PostMapping("/verify")
    public ResponseEntity<Void> verifyToken(@RequestBody TokenVerificationRequest request) {
        jwtService.verifyToken(request.token(), request.email());
        return ResponseEntity.ok().build();
    }
}
