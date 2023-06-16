package ua.dimalutsyuk.exceptions.handlers;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.iasasc.exceptions.AuthenticationException;
import ua.iasasc.exceptions.CipherNotFoundException;
import ua.iasasc.exceptions.TokenException;
import ua.iasasc.exceptions.impl.ErrorResponseImpl;

@RestControllerAdvice
public class MainHandler {
    @ExceptionHandler(value = {AuthenticationException.class})
    public ErrorResponse handleAuthenticationException(AuthenticationException authenticationException) {
        return new ErrorResponseImpl(authenticationException);
    }

    @ExceptionHandler(value = {TokenException.class})
    public ErrorResponse handleTokenException(TokenException tokenException) {
        return new ErrorResponseImpl(tokenException);
    }

    @ExceptionHandler(value = {CipherNotFoundException.class})
    public ErrorResponse handleCipherNotFoundException(CipherNotFoundException cipherNotFoundException) {
        return new ErrorResponseImpl(cipherNotFoundException);
    }
}
