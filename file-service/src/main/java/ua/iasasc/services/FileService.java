package ua.iasasc.services;

import org.springframework.web.multipart.MultipartFile;
import ua.iasasc.file.File;

import java.util.UUID;

public interface FileService {
    File getFileByUUID(UUID uuid);

    void saveFile(MultipartFile image, UUID uuid);

    void deleteAllFileByUUID(UUID uuid);
}
