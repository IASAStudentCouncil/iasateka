package ua.iasasc.excpetions.handlers;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.iasasc.exceptions.CipherNotFoundException;
import ua.iasasc.exceptions.impl.ErrorResponseImpl;

@RestControllerAdvice
public class MainHandler {
    @ExceptionHandler(value = {CipherNotFoundException.class})
    public ErrorResponse handleLinkNotFoundException(CipherNotFoundException exception) {
        return new ErrorResponseImpl(exception);
    }
}
