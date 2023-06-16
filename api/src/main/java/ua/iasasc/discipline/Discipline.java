package ua.iasasc.discipline;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import ua.iasasc.content.Content;
import ua.iasasc.discipline.enums.SelectiveType;
import ua.iasasc.teacher.Teacher;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Discipline {

    @Id
    private int id;

    @Column(name = "uuid", unique = true, nullable = false)
    @Generated(value = GenerationTime.INSERT)
    private UUID uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "courses", nullable = false)
    private String courses;

    @Column(name = "departments", nullable = false)
    private String departments;

    @Column(name = "selective_type", nullable = false)
    private SelectiveType selectiveType;

    @Column(name = "discipline_type", nullable = false)
    private String disciplineType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid")
    private List<Teacher> teachers;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid")
    private List<Discipline> relatedDisciplines;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid")
    private List<Content> contents;
}
