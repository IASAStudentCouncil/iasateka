package ua.iasasc.content.rating;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContentRatingId implements Serializable {

    @Column(name = "content_id", nullable = false)
    private Long contentId;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentRatingId that)) return false;

        if (getContentId() != null ? !getContentId().equals(that.getContentId()) : that.getContentId() != null)
            return false;
        return getAccountId() != null ? getAccountId().equals(that.getAccountId()) : that.getAccountId() == null;
    }

    @Override
    public int hashCode() {
        int result = getContentId() != null ? getContentId().hashCode() : 0;
        result = 31 * result + (getAccountId() != null ? getAccountId().hashCode() : 0);
        return result;
    }
}
