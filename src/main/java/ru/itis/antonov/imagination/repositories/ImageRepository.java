package ru.itis.antonov.imagination.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itis.antonov.imagination.models.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query(nativeQuery = true,
            value = "SELECT * FROM image INNER JOIN account a on image.author_id = a.id" +
            " LEFT JOIN subscribes s on a.id = s.user_to WHERE s.user_from = ?1 OR image.author_id=?1" +
            " LIMIT ?2 OFFSET ?3")
    List<Image> getFeed(Long userId, int limit, int offset);


    @Query(nativeQuery = true,
            value = "WITH RECURSIVE images AS(" +
                    "SELECT * FROM image WHERE id=?1 " +
                    "UNION ALL " +
                    "SELECT image.id, image.storage_path, image.author_id, image.parent_id FROM image INNER JOIN images ON image.parent_id = images.id)" +
                    "SELECT * FROM images")
    List<Image> getThread(Long imageId);
}
