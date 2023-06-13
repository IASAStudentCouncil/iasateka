package ua.dimalutsyuk.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public record TokenRequest(String email) {
    @JsonCreator
    public TokenRequest(@JsonProperty("email") String email) {
        this.email = email;
    }
}
