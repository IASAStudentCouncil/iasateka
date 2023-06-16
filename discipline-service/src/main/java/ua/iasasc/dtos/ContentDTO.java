package ua.iasasc.dtos;

import lombok.Data;
import ua.iasasc.file.File;

@Data
public class ContentDTO {

    private Integer id;

    private String description;

    private File file;
}
