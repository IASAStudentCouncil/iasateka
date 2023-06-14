package ua.iasasc.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collation = "verificationLinks")
@NoArgsConstructor
@Getter
@Setter
public class VerificationLink {
    @Indexed(unique = true)
    @Field(name = "index")
    private int index;
    @Field(name = "link")
    private String link;
    @Field(name = "email")
    private String email;
    @Field(name = "cipher")
    private String cipher;

    public VerificationLink(String link, String email, String cipher) {
        this.link = link;
        this.email = email;
        this.cipher = cipher;
    }
}
