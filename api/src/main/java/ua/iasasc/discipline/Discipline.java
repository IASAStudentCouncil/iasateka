package ua.iasasc.discipline;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import ua.iasasc.teacher.Teacher;
import ua.iasasc.teacher.TeacherDisciplineInfo;
import ua.iasasc.content.Content;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "disciplines")
@Getter
@Setter
//TODO implement validation
public class Discipline {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @NaturalId
    @Column(name = "slug", updatable = false, nullable = false)
    @Setter(AccessLevel.NONE)
    private String slug;

    public void buildSlug() {
        slug = name
                .toLowerCase()
                .replaceAll(" ", "-")
                .concat(department.name());
    }

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "is_selective", nullable = false)
    private boolean isSelective;

    @Enumerated(EnumType.STRING)
    @Column(name = "department", nullable = false)
    private Department department;

    @Column(name = "semesters", nullable = false, length = 37)
    private String semesters;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "related_disciplines",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "related_discipline_id")
    )
    private Set<Discipline> relatedDisciplines = new HashSet<>();

    public void addRelatedDiscipline(Discipline discipline) {
        relatedDisciplines.add(discipline);
        discipline.relatedDisciplines.add(this);
    }

    public void removeRelatedDiscipline(Discipline discipline) {
        relatedDisciplines.remove(discipline);
        discipline.relatedDisciplines.remove(this);
    }

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "discipline_content",
            joinColumns = @JoinColumn(name = "discipline_id"),
            inverseJoinColumns = @JoinColumn(name = "content_id")
    )
    private Set<Content> contents = new HashSet<>();

    public void addContent(Content content) {
        contents.add(content);
        content.getDisciplines().add(this);
    }

    public void removeContent(Content content) {
        contents.remove(content);
        content.getDisciplines().remove(this);
    }

    @OneToMany(
            mappedBy = "discipline",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TeacherDisciplineInfo> teacherDisciplineInfos = new ArrayList<>();

    public void addTeacher(Teacher teacher, TeacherDisciplineInfo info) {
        teacher.getDisciplineInfos().add(info);
        info.setTeacher(teacher);
        teacherDisciplineInfos.add(info);
        info.setDiscipline(this);
    }

    public void removeTeacher(TeacherDisciplineInfo info) {
        info.getTeacher().getDisciplineInfos().remove(info);
        info.setTeacher(null);
        teacherDisciplineInfos.remove(info);
        info.setDiscipline(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline that)) return false;

        return getSlug() != null ? getSlug().equals(that.getSlug()) : that.getSlug() == null;
    }

    @Override
    public int hashCode() {
        return getSlug() != null ? getSlug().hashCode() : 0;
    }
}
