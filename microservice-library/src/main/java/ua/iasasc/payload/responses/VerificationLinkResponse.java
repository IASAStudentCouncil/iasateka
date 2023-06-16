package ua.iasasc.payload.responses;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record VerificationLinkResponse(String email, String verificationLink) {
    @JsonCreator
    public VerificationLinkResponse(@JsonProperty("email") String email, @JsonProperty("verification_link") String verificationLink) {
        this.email = email;
        this.verificationLink = verificationLink;
    }
}
