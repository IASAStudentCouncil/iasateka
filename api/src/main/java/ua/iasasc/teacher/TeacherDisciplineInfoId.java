package ua.iasasc.teacher;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDisciplineInfoId implements Serializable {

    @Column(name = "teacher_id", nullable = false)
    private Long teacherId;

    @Column(name = "discipline_id", nullable = false)
    private Long disciplineId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherDisciplineInfoId that)) return false;

        if (!Objects.equals(teacherId, that.teacherId)) return false;
        return Objects.equals(disciplineId, that.disciplineId);
    }

    @Override
    public int hashCode() {
        int result = teacherId != null ? teacherId.hashCode() : 0;
        result = 31 * result + (disciplineId != null ? disciplineId.hashCode() : 0);
        return result;
    }
}
