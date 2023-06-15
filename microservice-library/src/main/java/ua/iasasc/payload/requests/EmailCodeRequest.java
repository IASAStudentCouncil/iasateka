package ua.iasasc.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record EmailCodeRequest(String email, String code) {
    @JsonCreator
    public EmailCodeRequest(@JsonProperty("email") String email, @JsonProperty("code") String code) {
        this.email = email;
        this.code = code;
    }
}
