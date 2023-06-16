package ua.dimalutsyuk.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ua.iasasc.file.File;

import java.util.List;

@Data
public class TeacherDTO {
    private int id;

    private String name;

    private String surname;

    private String patronymic;

    private List<TeacherDisciplineDTO> disciplines;

    private List<ContentDTO> contents;

    @JsonProperty("birth_year")
    private int birthYear;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("academic_degree")
    private String academicDegree;

    @JsonProperty("survey_link")
    private String surveyLink;

    @JsonProperty("interview_link")
    private String interviewLink;

    private File file;

    @JsonProperty("publication_links")
    private List<PublicationDTO> publicationLinks;
}
