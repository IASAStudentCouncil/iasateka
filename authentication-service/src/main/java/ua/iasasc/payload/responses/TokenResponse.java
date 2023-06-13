package ua.iasasc.payload.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public record TokenResponse(String email, String token) {
    @JsonCreator
    public TokenResponse(@JsonProperty("email") String email, @JsonProperty("token") String token) {
        this.email = email;
        this.token = token;
    }
}
