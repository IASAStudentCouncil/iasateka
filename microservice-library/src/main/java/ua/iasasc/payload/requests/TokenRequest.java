package ua.iasasc.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenRequest(String email) {
    @JsonCreator
    public TokenRequest(@JsonProperty("email") String email) {
        this.email = email;
    }
}