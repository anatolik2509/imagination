package ru.itis.antonov.imagination.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.antonov.imagination.dto.AlbumDto;
import ru.itis.antonov.imagination.dto.ImageDto;
import ru.itis.antonov.imagination.exception.NoSuchImageException;
import ru.itis.antonov.imagination.exception.NoSuchUserException;
import ru.itis.antonov.imagination.models.Album;
import ru.itis.antonov.imagination.repositories.AlbumRepository;
import ru.itis.antonov.imagination.repositories.ImageRepository;
import ru.itis.antonov.imagination.repositories.UserRepository;
import ru.itis.antonov.imagination.services.interfaces.AlbumService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private AlbumRepository albumRepository;
    private UserRepository userRepository;
    private ImageRepository imageRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository, UserRepository userRepository) {
        this.albumRepository = albumRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<AlbumDto> getUserAlbums(Long userId) {
        return AlbumDto.from(albumRepository.getAlbumByOwner(userRepository.findById(userId).orElseThrow(NoSuchUserException::new)));
    }

    @Override
    public List<ImageDto> getAlbumImages(Long albumId) {
        return ImageDto.from(albumRepository.findById(albumId).orElseThrow(NoSuchImageException::new).getImages());
    }

    @Override
    public AlbumDto createAlbum(Long userId, String name) {
        Album newAlbum = Album.builder()
                .name(name)
                .owner(userRepository.findById(userId).orElseThrow(NoSuchUserException::new))
                .images(new ArrayList<>())
                .build();
        albumRepository.save(newAlbum);
        return AlbumDto.from(newAlbum);
    }

    @Override
    public void addImageToAlbum(Long imageId, Long albumId) {
        Album album = albumRepository.findById(albumId).orElseThrow(NoSuchImageException::new);
        album.getImages().add(imageRepository.findById(imageId).orElseThrow(NoSuchImageException::new));
    }

    @Override
    public AlbumDto getAlbumById(Long albumId) {
        Album album = albumRepository.findById(albumId).orElseThrow(NoSuchImageException::new);
        return AlbumDto.from(album);
    }

    @Autowired
    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }
}
