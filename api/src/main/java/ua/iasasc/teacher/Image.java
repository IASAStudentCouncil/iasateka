package ua.iasasc.teacher;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "images")
@Getter
@Setter
public class Image {

    @Id
    private Long id;

    @Column(name = "link_to", nullable = false)
    private String linkTo;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "teacher_id", unique = true, nullable = false)
    private Teacher teacher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Image image)) return false;

        return getId() != null ? getId().equals(image.getId()) : image.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
