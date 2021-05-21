package ru.itis.antonov.imagination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.antonov.imagination.models.Album;
import ru.itis.antonov.imagination.models.Image;
import ru.itis.antonov.imagination.models.User;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumDto {
    private long id;

    private List<ImageDto> images;

    private String name;

    public static AlbumDto from(Album album){
        return AlbumDto.builder()
                .id(album.getId())
                .name(album.getName())
                .images(ImageDto.from(album.getImages()))
                .build();
    }

    public static List<AlbumDto> from(List<Album> albums){
        return albums.stream().map(AlbumDto::from).collect(Collectors.toList());
    }
}
