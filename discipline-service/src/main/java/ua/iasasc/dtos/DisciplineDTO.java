package ua.iasasc.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ua.iasasc.discipline.enums.SelectiveType;

import java.util.List;

@Data
public class DisciplineDTO {

    private int id;

    private String name;

    private String description;

    private String courses;

    private String departments;

    @JsonProperty("selective_type")
    private SelectiveType selectiveType;

    @JsonProperty("discipline_type")
    private String disciplineType;

    private List<TeacherDTO> teachers;

    @JsonProperty("related_disciplines")
    private List<RelatedDisciplineDTO> relatedDisciplines;

    private List<ContentDTO> contents;
}
