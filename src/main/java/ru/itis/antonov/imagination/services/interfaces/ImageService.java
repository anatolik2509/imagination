package ru.itis.antonov.imagination.services.interfaces;

import ru.itis.antonov.imagination.dto.AlbumDto;
import ru.itis.antonov.imagination.dto.ImageDto;
import ru.itis.antonov.imagination.dto.form.ImageForm;

import java.util.List;

public interface ImageService {
    ImageDto saveImage(ImageForm form, Long authorId);

    List<ImageDto> getFeed(Long userId, int limit, int offset);

    List<ImageDto> getThread(Long imageId);

    ImageDto getImageById(Long id, Long userId);

    ImageDto update(Long id, ImageForm form, Long userId);

    void delete(Long id, Long userId);

    List<AlbumDto> getUserAlbums(Long userId);

    void addImageToAlbum(Long imageId, Long AlbumId);
}
