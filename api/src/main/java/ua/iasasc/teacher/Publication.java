package ua.iasasc.teacher;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Publication {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "teacher_id", nullable = false)
    private Integer teacherId;
}
