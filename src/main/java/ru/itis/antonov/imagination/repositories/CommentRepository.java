package ru.itis.antonov.imagination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.antonov.imagination.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
