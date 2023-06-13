package ua.dimalutsyuk.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class TokenException extends RuntimeException implements ExceptionFrame {
    private final HttpStatusCode responseStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public TokenException(String message) {
        super(message);
    }
}
