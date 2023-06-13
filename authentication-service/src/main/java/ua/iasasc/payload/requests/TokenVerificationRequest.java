package ua.iasasc.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public record TokenVerificationRequest(String email, String token) {
    @JsonCreator
    public TokenVerificationRequest(@JsonProperty("email") String email, @JsonProperty("token") String token) {
        this.email = email;
        this.token = token;
    }
}
