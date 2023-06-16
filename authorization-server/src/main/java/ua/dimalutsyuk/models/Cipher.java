package ua.dimalutsyuk.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "ciphers")
@Getter
@Setter
@NoArgsConstructor
public class Cipher {
    @Indexed(name = "id")
    private int id;
    @Field("cipher")
    private String cipher;
    @Field("email")
    private String email;

    public Cipher(String cipher, String email) {
        this.cipher = cipher;
        this.email = email;
    }
}
