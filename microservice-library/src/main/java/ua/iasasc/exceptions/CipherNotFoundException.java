package ua.iasasc.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class CipherNotFoundException extends RuntimeException implements ExceptionFrame {
    private final HttpStatusCode responseStatus;

    public CipherNotFoundException(String message, HttpStatusCode responseStatus) {
        super(message);
        this.responseStatus = responseStatus;
    }
}
