package ru.itis.antonov.imagination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.antonov.imagination.models.Image;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageDto {
    private Long id;

    private String authorUsername;
    private Long authorId;

    private String path;

    private boolean viewerLiked;
    private boolean viewerOwner;
    private int likesCount;

    private Long parentId;

    private List<CommentDto> comments;

    public static ImageDto from(Image image){
        return ImageDto.builder()
                .id(image.getId())
                .authorUsername(image.getAuthor().getNickname())
                .authorId(image.getAuthor().getId())
                .path(image.getStoragePath())
                .viewerLiked(false)
                .likesCount(image.getLikes() != null?image.getLikes().size() : 0)
                .comments(image.getComments() != null?CommentDto.from(image.getComments()): new ArrayList<>())
                .build();
    }

    public static List<ImageDto> from(List<Image> imageList){
        return imageList.stream().map(ImageDto::from).collect(Collectors.toList());
    }
}
