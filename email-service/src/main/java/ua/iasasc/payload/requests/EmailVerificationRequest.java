package ua.iasasc.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record EmailVerificationRequest(String email) {
    @JsonCreator
    public EmailVerificationRequest(@JsonProperty("email") String email) {
        this.email = email;
    }
}
