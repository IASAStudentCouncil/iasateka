package ua.dimalutsyuk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "credentials")
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;
    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;
    @Column(name = "password", nullable = false, unique = false)
    private String password;
    @Column(name = "telegram_username", nullable = false, unique = true)
    private String telegramUsername;
    @Column(name = "email_verified", nullable = false, unique = false)
    private boolean emailVerified;
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false, unique = false)
    private Role role;

    public Credentials(String email, String password, String telegramUsername) {
        this.email = email;
        this.password = password;
        this.telegramUsername = telegramUsername;
    }
}
