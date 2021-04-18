package ru.itis.antonov.imagination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.antonov.imagination.models.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
