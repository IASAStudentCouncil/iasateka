package ua.iasasc.excpetions;

import org.springframework.http.HttpStatusCode;

public interface ExceptionFrame {
    HttpStatusCode getResponseStatus();
    String getMessage();
}
