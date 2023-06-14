package ua.iasasc.excpetions.handlers;

import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ua.iasasc.excpetions.LinkNotFoundException;

@RestControllerAdvice
public class MainHandler {
    @ExceptionHandler(value = {LinkNotFoundException.class})
    public ErrorResponse handleLinkNotFoundException(LinkNotFoundException exception) {
        return new ErrorResponseImpl(exception);
    }
}
