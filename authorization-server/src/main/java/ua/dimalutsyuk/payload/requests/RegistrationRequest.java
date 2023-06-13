package ua.dimalutsyuk.payload.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record RegistrationRequest(String email, String password, String telegramUsername) {
    @JsonCreator
    public RegistrationRequest(@JsonProperty("email") String email,
                               @JsonProperty("password") String password,
                               @JsonProperty("telegram_username") String telegramUsername) {
        this.email = email;
        this.password = password;
        this.telegramUsername = telegramUsername;
    }
}
