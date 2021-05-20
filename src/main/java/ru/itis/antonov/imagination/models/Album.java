package ru.itis.antonov.imagination.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User owner;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Image> images;

    private String name;

    @Enumerated(EnumType.STRING)
    private AlbumAccess access;

    private enum AlbumAccess{
        PUBLIC, PRIVATE
    }
}
