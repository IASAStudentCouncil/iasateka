package ua.iasasc.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class FileUploadException extends RuntimeException {
    private final HttpStatusCode errorCode = HttpStatus.NOT_FOUND;

    public FileUploadException(String fileName) {
        super("Error uploading file " + fileName);
    }
}
