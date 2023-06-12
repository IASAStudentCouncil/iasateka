package ua.dimalutsyuk.exceptions.handlers;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;

@RequiredArgsConstructor
@Getter
public class ErroResponseImpl implements ErrorResponse {
    private final HttpStatusCode responseCode;
    private final String errorMessage;

    @Override
    public HttpStatusCode getStatusCode() {
        return responseCode;
    }

    @Override
    public ProblemDetail getBody() {
        return ProblemDetail.forStatusAndDetail(responseCode, errorMessage);
    }
}
