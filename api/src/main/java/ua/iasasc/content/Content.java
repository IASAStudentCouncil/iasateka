package ua.iasasc.content;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import ua.iasasc.account.Account;
import ua.iasasc.discipline.Discipline;
import ua.iasasc.file.File;
import ua.iasasc.teacher.Teacher;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Content {

    @Id
    @Column(name = "uuid", unique = true, nullable = false)
    private Integer id;

    @Column(name = "uuid", unique = true, nullable = false)
    @Generated(value = GenerationTime.INSERT)
    private UUID uuid;

    @Column(name = "content_type", nullable = false)
    private String contentType;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Discipline discipline;

    @ManyToOne
    private Teacher teacher;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "edited_at", nullable = false)
    private LocalDate edited_at;

    @Column(name = "is_verified", nullable = false)
    private boolean isVerified;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid", insertable = false, updatable = false)
    private File file;
}
