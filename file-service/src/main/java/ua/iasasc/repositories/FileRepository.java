package ua.iasasc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.iasasc.file.File;

import java.util.UUID;

public interface FileRepository extends JpaRepository<File, Integer> {
    File findImageByUuid(UUID uuid);

    void deleteByUuid(UUID uuid);
}
