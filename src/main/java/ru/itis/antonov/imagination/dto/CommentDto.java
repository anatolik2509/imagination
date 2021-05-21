package ru.itis.antonov.imagination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.antonov.imagination.models.Comment;
import ru.itis.antonov.imagination.models.Image;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {
    private String authorName;
    private String content;

    public static CommentDto from(Comment comment){
        return CommentDto.builder()
                .authorName(comment.getAuthor().getNickname())
                .content(comment.getContent())
                .build();
    }

    public static List<CommentDto> from(List<Comment> commentList){
        return commentList.stream().map(CommentDto::from).collect(Collectors.toList());
    }
}
