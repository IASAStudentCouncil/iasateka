package ua.iasasc.teacher;

import jakarta.persistence.*;
import lombok.*;
import ua.iasasc.discipline.Discipline;

import java.time.LocalDate;

@Entity
@Table(name = "teacher_discipline_infos")
@Getter
@Setter
@NoArgsConstructor
//TODO implement validation
public class TeacherDisciplineInfo {

    @EmbeddedId
    private TeacherDisciplineInfoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("teacher_id")
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("discipline_id")
    private Discipline discipline;

    @Column(name = "isTaught", nullable = false)
    private boolean isTaught;

    @Column(name = "startedTeaching", nullable = false)
    private LocalDate startedTeaching;

    @Column(name = "endedTeaching")
    private LocalDate endedTeaching;

    public TeacherDisciplineInfo(Teacher teacher, Discipline discipline) {
        this.teacher = teacher;
        this.discipline = discipline;
        this.id = new TeacherDisciplineInfoId(teacher.getId(), discipline.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherDisciplineInfo that)) return false;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
