package ua.iasasc.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class LinkNotFoundException extends RuntimeException implements ExceptionFrame {
    private final HttpStatusCode responseStatus;

    public LinkNotFoundException(String message, HttpStatusCode responseStatus) {
        super(message);
        this.responseStatus = responseStatus;
    }
}
