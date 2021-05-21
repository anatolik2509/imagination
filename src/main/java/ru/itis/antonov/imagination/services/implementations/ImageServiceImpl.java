package ru.itis.antonov.imagination.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.antonov.imagination.dto.AlbumDto;
import ru.itis.antonov.imagination.dto.ImageDto;
import ru.itis.antonov.imagination.dto.form.ImageForm;
import ru.itis.antonov.imagination.exception.NoSuchImageException;
import ru.itis.antonov.imagination.exception.NoSuchUserException;
import ru.itis.antonov.imagination.exception.NotOwnerException;
import ru.itis.antonov.imagination.models.Image;
import ru.itis.antonov.imagination.models.User;
import ru.itis.antonov.imagination.repositories.ImageRepository;
import ru.itis.antonov.imagination.repositories.UserRepository;
import ru.itis.antonov.imagination.services.interfaces.AlbumService;
import ru.itis.antonov.imagination.services.interfaces.ImageService;
import ru.itis.antonov.imagination.services.interfaces.MediaService;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;
    private MediaService mediaService;
    private UserRepository userRepository;
    private AlbumService albumService;

    public ImageServiceImpl(ImageRepository imageRepository, MediaService mediaService) {
        this.imageRepository = imageRepository;
        this.mediaService = mediaService;
    }

    @Override
    public ImageDto saveImage(ImageForm form, Long authorId) {
        String path = mediaService.save(form);
        Image newImage = Image.builder()
                .author(userRepository.findById(authorId).orElseThrow(NoSuchUserException::new))
                .storagePath(path)
                .build();
        if(form.getParentId() != -1){
            newImage.setParent(imageRepository.findById(form.getParentId()).orElseThrow(NoSuchImageException::new));
        }
        imageRepository.save(newImage);
        ImageDto imageDto = ImageDto.from(newImage);
        imageDto.setViewerOwner(true);
        return imageDto;
    }

    @Override
    public List<ImageDto> getFeed(Long userId, int limit, int offset) {
        return ImageDto.from(imageRepository.getFeed(userId, limit, offset));
    }

    @Override
    public List<ImageDto> getThread(Long imageId) {
        return ImageDto.from(imageRepository.getThread(imageId));
    }

    @Override
    public ImageDto getImageById(Long id, Long userId) {
        Image image = imageRepository.findById(id).orElseThrow(NoSuchImageException::new);
        ImageDto imageDto = ImageDto.from(image);
        imageDto.setViewerOwner(imageDto.getAuthorId().equals(userId));
        User user = userRepository.findById(userId).orElseThrow(NoSuchUserException::new);
        imageDto.setViewerLiked(image.getLikes().contains(user));
        return imageDto;
    }

    @Override
    public ImageDto update(Long id, ImageForm form, Long userId) {
        Image image = imageRepository.findById(id).orElseThrow(NoSuchImageException::new);
        if(image.getAuthor().getId() != userId){
            throw new NotOwnerException();
        }
        String path = mediaService.save(form);
        image.setStoragePath(path);
        imageRepository.save(image);
        return ImageDto.from(image);
    }

    @Override
    public void delete(Long id, Long userId) {
        Image image = imageRepository.findById(id).orElseThrow(NoSuchImageException::new);
        if(image.getAuthor().getId() != userId){
            throw new NotOwnerException();
        }
        imageRepository.delete(image);
    }

    @Override
    public List<AlbumDto> getUserAlbums(Long userId) {
        return albumService.getUserAlbums(userId);
    }

    @Override
    public void addImageToAlbum(Long imageId, Long AlbumId) {

    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }
}
