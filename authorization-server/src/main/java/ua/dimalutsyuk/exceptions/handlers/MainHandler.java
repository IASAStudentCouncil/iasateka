package ua.dimalutsyuk.exceptions.handlers;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.dimalutsyuk.exceptions.AuthenticationException;

@RestControllerAdvice
public class MainHandler {
    @ExceptionHandler(value = {AuthenticationException.class})
    public ErrorResponse handleAuthenticationException(AuthenticationException authenticationException) {
        return new ErroResponseImpl(authenticationException.getResponseCode(),
                authenticationException.getMessage());
    }
}
