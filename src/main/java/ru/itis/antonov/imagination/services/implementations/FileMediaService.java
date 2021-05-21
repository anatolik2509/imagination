package ru.itis.antonov.imagination.services.implementations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.antonov.imagination.dto.form.ImageForm;
import ru.itis.antonov.imagination.exception.ImageFileNotFoundException;
import ru.itis.antonov.imagination.services.interfaces.MediaService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Slf4j
public class FileMediaService implements MediaService {

    @Value("${media.repository.path}")
    private String repositoryPath;


    @Override
    public String save(ImageForm form) {
        MultipartFile multipartFile = form.getFile();
        String filename = UUID.randomUUID().toString() + ".png";
        Path pathToSave = Paths.get(repositoryPath).resolve(filename);

        File file = new File(String.valueOf(pathToSave));
        try {
            file.createNewFile();
            multipartFile.transferTo(file);
        } catch (IOException ioException) {
            log.error(ioException.getMessage());
        }
        return filename;
    }

    @Override
    public InputStream getImage(String path) {
        try {
            return new FileInputStream(Paths.get(repositoryPath).resolve(path).toString());
        } catch (FileNotFoundException e) {
            throw new ImageFileNotFoundException(e);
        }
    }
}
