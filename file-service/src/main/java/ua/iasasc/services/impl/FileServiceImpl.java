package ua.iasasc.services.impl;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.iasasc.exceptions.FileUploadException;
import ua.iasasc.file.File;
import ua.iasasc.repositories.FileRepository;
import ua.iasasc.services.FileService;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {
    private static final int SALT_LENGTH = 7;

    private final FileRepository fileRepository;

    private final BlobContainerClient imageContainerClient;

    @Override
    public File getFileByUUID(UUID uuid) {
        return fileRepository.findImageByUuid(uuid);
    }

    @Override
    public void saveFile(MultipartFile file, UUID uuid) {
        BlobClient blobClient = imageContainerClient.getBlobClient(file.getName() + "-" + uuid.toString() + "-" + generateRandomStringSalt() + ".png");
        uploadFile(blobClient, file);

        File imageToSave = File.builder()
                .url(blobClient.getBlobUrl())
                .uuid(uuid)
                .build();

        fileRepository.save(imageToSave);
    }

    private void uploadFile(BlobClient blobClient, MultipartFile file) {
        try {
            blobClient.upload(file.getInputStream(), file.getSize(), true);
        } catch (IOException e) {
            throw new FileUploadException(file.getName());
        }
    }

    private String generateRandomStringSalt() {
        Random random = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < SALT_LENGTH; i++) {
            stringBuilder.append(random.nextInt(10));
        }

        return stringBuilder.toString();
    }

    @Override
    public void deleteAllFileByUUID(UUID uuid) {
        imageContainerClient
                .listBlobs()
                .stream()
                .filter(blobItem -> blobItem.getName().contains(uuid.toString()))
                .forEach(blobItem -> imageContainerClient.getBlobClient(blobItem.getName()).delete());

        fileRepository.deleteByUuid(uuid);
    }
}
