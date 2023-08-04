package ua.iasasc.content.rating;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.iasasc.account.Account;
import ua.iasasc.content.Content;

@Entity
@Table(name = "content_rating")
@Getter
@Setter
@NoArgsConstructor
//TODO implement validation
public class ContentRating {

    @EmbeddedId
    private ContentRatingId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("contentId")
    private Content content;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("accountId")
    private Account account;

    @Column(name = "rating", nullable = false)
    private Integer ratingVal;

    public ContentRating(Content content, Account account, Integer ratingVal) {
        this.content = content;
        this.account = account;
        this.ratingVal = ratingVal;
        this.id = new ContentRatingId(content.getId(), account.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentRating that)) return false;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
