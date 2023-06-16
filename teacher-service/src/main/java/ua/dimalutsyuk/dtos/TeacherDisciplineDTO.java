package ua.dimalutsyuk.dtos;

import lombok.Data;

@Data
public class TeacherDisciplineDTO {

    private Integer id;

    private DisciplineDTO discipline;

    private String status;
}
