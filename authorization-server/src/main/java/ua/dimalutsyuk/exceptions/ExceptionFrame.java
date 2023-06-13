package ua.dimalutsyuk.exceptions;

import org.springframework.http.HttpStatusCode;

public interface ExceptionFrame {
    HttpStatusCode getResponseStatus();

    String getMessage();
}