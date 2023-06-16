package ua.iasasc.teacher;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import ua.iasasc.content.Content;
import ua.iasasc.file.File;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "image_uuid", unique = true, nullable = false)
    @Generated(value = GenerationTime.INSERT)
    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private List<TeacherDiscipline> disciplines;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid")
    private List<Content> contents;

    @Column(name = "birth_year", nullable = false)
    private int birthYear;

    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @Column(name = "academic_degree", nullable = false)
    private String academicDegree;

    @Column(name = "survey_link", nullable = false)
    private String surveyLink;

    @Column(name = "interview_link", nullable = false)
    private String interviewLink;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid", insertable = false, updatable = false)
    private File file;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private List<Publication> publicationLinks;
}
