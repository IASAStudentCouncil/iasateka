package ua.dimalutsyuk.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.dimalutsyuk.clients.TokenClient;
import ua.dimalutsyuk.exceptions.TokenException;
import ua.dimalutsyuk.payload.requests.TokenRequest;
import ua.dimalutsyuk.payload.responses.TokenResponse;
import ua.dimalutsyuk.services.TokenService;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenClient tokenClient;

    @Override
    public String issueToken(String email) {
        ResponseEntity<TokenResponse> response = tokenClient.issueToken(new TokenRequest(email));
        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            return response.getBody().token();
        } else {
            throw new TokenException("Internal server error in creating JWT token");
        }
    }
}
