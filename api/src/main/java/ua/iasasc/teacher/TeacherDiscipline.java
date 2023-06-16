package ua.iasasc.teacher;

import jakarta.persistence.*;
import ua.iasasc.discipline.Discipline;

@Entity
public class TeacherDiscipline {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid", insertable = false, updatable = false)
    private Discipline discipline;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "teacher_id", nullable = false)
    private Integer teacherId;
}
