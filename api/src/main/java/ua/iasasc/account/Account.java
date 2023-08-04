package ua.iasasc.account;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import ua.iasasc.content.Content;
import ua.iasasc.content.rating.ContentRating;
import ua.iasasc.FullName;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
//TODO implement validation
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NaturalId
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Embedded
    private FullName fullName;

    @Column(name = "groupName")
    private String groupName;

    //TODO It would be better if Bohdan implemented Role field

    @OneToMany(
            mappedBy = "owner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Content> contents = new ArrayList<>();

    public void addContent(Content content) {
        contents.add(content);
        content.setOwner(this);
    }

    public void removeContent(Content content) {
        contents.remove(content);
        content.setOwner(null);
    }

    @OneToMany(
            mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ContentRating> ratings = new ArrayList<>();

    @Column(name = "isDeleted", nullable = false)
    private boolean isDeleted = false;

    @Column(name = "isBanned", nullable = false)
    private boolean isBanned = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;

        return getEmail() != null ? getEmail().equals(account.getEmail()) : account.getEmail() == null;
    }

    @Override
    public int hashCode() {
        return getEmail() != null ? getEmail().hashCode() : 0;
    }
}
