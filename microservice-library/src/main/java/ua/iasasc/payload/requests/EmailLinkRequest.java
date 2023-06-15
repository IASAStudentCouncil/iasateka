package ua.iasasc.payload.requests;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record EmailLinkRequest(String email, String link) {
    @JsonCreator
    public EmailLinkRequest(@JsonProperty("email") String email, @JsonProperty("link") String link) {
        this.email = email;
        this.link = link;
    }
}
