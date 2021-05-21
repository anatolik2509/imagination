package ru.itis.antonov.imagination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.antonov.imagination.models.Album;
import ru.itis.antonov.imagination.models.User;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> getAlbumByOwner(User user);
}
