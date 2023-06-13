package ua.iasasc.exceptions.handlers;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.iasasc.exceptions.TokenException;

@RestControllerAdvice
public class MainHandler {
    @ExceptionHandler(value = {TokenException.class})
    public ErrorResponse handleTokenException(TokenException tokenException) {
        return new ErrorResponseImpl(tokenException);
    }
}
