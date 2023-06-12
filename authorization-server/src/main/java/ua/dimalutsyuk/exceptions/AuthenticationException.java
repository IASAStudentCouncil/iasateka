package ua.dimalutsyuk.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class AuthenticationException extends RuntimeException {
    private final HttpStatusCode responseCode = HttpStatus.UNAUTHORIZED;

    public AuthenticationException(String message) {
        super(message);
    }

}
