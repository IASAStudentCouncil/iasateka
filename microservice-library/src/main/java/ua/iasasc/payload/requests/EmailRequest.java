package ua.iasasc.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record EmailRequest(String email) {
    @JsonCreator
    public EmailRequest(@JsonProperty("email") String email) {
        this.email = email;
    }
}
