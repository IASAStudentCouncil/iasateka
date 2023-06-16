package ua.iasasc.account;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import ua.iasasc.content.Content;

import java.util.List;
import java.util.UUID;

@Entity
public class Account {

    @Id
    @Column(name = "uuid", unique = true, nullable = false)
    private Integer id;

    @Column(name = "uuid", unique = true, nullable = false)
    @Generated(value = GenerationTime.INSERT)
    private UUID uuid;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "group", nullable = false)
    private String group;

    // TODO Role

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid")
    private List<Content> contents;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;

    @Column(name = "is_banned", nullable = false)
    private boolean isBanned;
}
