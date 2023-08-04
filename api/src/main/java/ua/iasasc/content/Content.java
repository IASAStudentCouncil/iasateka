package ua.iasasc.content;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import ua.iasasc.content.rating.ContentRating;
import ua.iasasc.discipline.Discipline;
import ua.iasasc.teacher.Teacher;
import ua.iasasc.account.Account;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "contents")
@Getter
@Setter
//TODO implement validation
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NaturalId
    @Column(name = "uuid", unique = true, updatable = false)
    private final UUID uuid = UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ContentType type;

    @Column(name = "last_modified", nullable = false)
    private LocalDate lastModified;

    @Column(name = "is_verified", nullable = false)
    private Boolean isVerified;

    @Column(name = "resource_link", nullable = false, unique = true)
    private String resourceLink;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account owner;

    @OneToMany(
            mappedBy = "content",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ContentRating> ratings = new ArrayList<>();

    public void addRating(Account account, int ratingVal) {
        ContentRating rating = new ContentRating(this, account, ratingVal);
        account.getRatings().add(rating);
        ratings.add(rating);
    }

    public void removeRating(ContentRating rating) {
        rating.getAccount().getRatings().remove(rating);
        rating.setAccount(null);
        ratings.remove(rating);
        rating.setContent(null);
    }

    @ManyToMany(
            mappedBy = "contents"
    )
    private Set<Discipline> disciplines = new HashSet<>();

    @ManyToMany(
            mappedBy = "contents"
    )
    private Set<Teacher> teachers = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Content content)) return false;

        return getId() != null ? getUuid().equals(content.getUuid()) : content.getUuid() == null;
    }

    @Override
    public int hashCode() {
        return getUuid() != null ? getUuid().hashCode() : 0;
    }
}
