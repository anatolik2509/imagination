package ru.itis.antonov.imagination.services.interfaces;

import ru.itis.antonov.imagination.dto.AlbumDto;
import ru.itis.antonov.imagination.dto.ImageDto;
import ru.itis.antonov.imagination.models.Album;

import java.util.List;

public interface AlbumService {

    List<AlbumDto> getUserAlbums(Long userId);

    List<ImageDto> getAlbumImages(Long albumId);

    AlbumDto createAlbum(Long userId, String name);

    void addImageToAlbum(Long imageId, Long albumId);

    AlbumDto getAlbumById(Long albumId);

}
