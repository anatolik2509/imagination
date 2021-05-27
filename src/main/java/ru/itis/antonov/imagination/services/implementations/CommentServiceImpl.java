package ru.itis.antonov.imagination.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.antonov.imagination.dto.form.CommentForm;
import ru.itis.antonov.imagination.exception.NoSuchImageException;
import ru.itis.antonov.imagination.exception.NoSuchUserException;
import ru.itis.antonov.imagination.models.Comment;
import ru.itis.antonov.imagination.models.Image;
import ru.itis.antonov.imagination.repositories.CommentRepository;
import ru.itis.antonov.imagination.repositories.ImageRepository;
import ru.itis.antonov.imagination.repositories.UserRepository;
import ru.itis.antonov.imagination.services.interfaces.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ImageRepository imageRepository;
    private UserRepository userRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(CommentForm form, Long userId, Long imageId) {
        Image image = imageRepository.findById(imageId).orElseThrow(NoSuchImageException::new);
        Comment comment = Comment.builder()
                .author(userRepository.findById(userId).orElseThrow(NoSuchUserException::new))
                .content(form.getContent())
                .image(image)
                .build();
        commentRepository.save(comment);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

}
