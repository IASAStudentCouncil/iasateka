package ua.dimalutsyuk.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.iasasc.payload.requests.TokenRequest;
import ua.iasasc.payload.responses.TokenResponse;

@FeignClient(name = "tokenClient", url = "")
public interface TokenClient {
    @PostMapping
    ResponseEntity<TokenResponse> issueToken(@RequestBody TokenRequest request);
}
