package ua.iasasc.teacher;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import ua.iasasc.FullName;
import ua.iasasc.content.Content;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "teachers")
@Getter
@Setter
//TODO implement validation
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NaturalId
    @Column(name = "uuid", unique = true, updatable = false)
    private final UUID uuid = UUID.randomUUID();

    @Valid
    @Embedded
    private FullName fullName;

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TeacherDisciplineInfo> disciplineInfos = new ArrayList<>();

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "degree")
    private String degree;

    @Column(name = "review_link")
    private String reviewLink;

    @Column(name = "interview_link")
    private String interviewLink;

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Publication> publications = new ArrayList<>();

    public void addPublication(Publication publication) {
        publications.add(publication);
        publication.setTeacher(this);
    }

    public void removePublication(Publication publication) {
        publications.remove(publication);
        publication.setTeacher(null);
    }

    @OneToOne(
            mappedBy = "teacher",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @PrimaryKeyJoinColumn
    private Image image;

    public void setImage(Image image) {
        if (image == null) {
            if (this.image != null) {
                this.image.setTeacher(null);
            }
        }
        else {
            image.setTeacher(this);
        }
        this.image = image;
    }

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "teacher_content",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "content_id")
    )
    Set<Content> contents = new HashSet<>();

    public void addContent(Content content) {
        contents.add(content);
        content.getTeachers().add(this);
    }

    public void removeContent(Content content) {
        contents.remove(content);
        content.getTeachers().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;

        return getUuid().equals(teacher.getUuid());
    }

    @Override
    public int hashCode() {
        return getUuid().hashCode();
    }
}
