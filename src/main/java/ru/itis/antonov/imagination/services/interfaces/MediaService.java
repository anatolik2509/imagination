package ru.itis.antonov.imagination.services.interfaces;

import ru.itis.antonov.imagination.dto.form.ImageForm;

import java.io.InputStream;

public interface MediaService {
    String save(ImageForm form);

    InputStream getImage(String path);
}
