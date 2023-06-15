package ua.iasasc.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class AuthenticationException extends RuntimeException implements ExceptionFrame {
    private final HttpStatusCode responseStatus = HttpStatus.UNAUTHORIZED;

    public AuthenticationException(String message) {
        super(message);
    }
}
