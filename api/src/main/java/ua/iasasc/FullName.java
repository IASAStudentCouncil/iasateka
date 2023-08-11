package ua.iasasc;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class FullName {

    @NotBlank
    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank
    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank
    @NotNull
    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    public String getFullName() {
        return lastName + " " + firstName + " " + patronymic;
    }
}
