package ua.iasasc.exceptions.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import ua.iasasc.exceptions.ExceptionFrame;

@RequiredArgsConstructor
public class ErrorResponseImpl implements ErrorResponse {
    private final ExceptionFrame exception;

    @Override
    public HttpStatusCode getStatusCode() {
        return exception.getResponseStatus();
    }

    @Override
    public ProblemDetail getBody() {
        return ProblemDetail
                .forStatusAndDetail(exception.getResponseStatus(), exception.getMessage());
    }
}
