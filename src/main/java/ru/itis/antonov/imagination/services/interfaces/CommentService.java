package ru.itis.antonov.imagination.services.interfaces;

import ru.itis.antonov.imagination.dto.form.CommentForm;

public interface CommentService {
    void addComment(CommentForm form, Long userId, Long imageId);
}
