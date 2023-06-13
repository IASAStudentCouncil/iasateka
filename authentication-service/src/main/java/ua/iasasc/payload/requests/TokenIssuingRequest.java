package ua.iasasc.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TokenIssuingRequest {
    private String email;

    @JsonCreator
    public TokenIssuingRequest(@JsonProperty("email") String email) {
        this.email = email;
    }
}
