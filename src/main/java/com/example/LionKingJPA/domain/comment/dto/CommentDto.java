package com.example.LionKingJPA.domain.comment.dto;

import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String content;

    public static Comment toEntity(CommentDto commentDto, Article article) {
        return Comment.builder()
                .content(commentDto.content)
                .article(article)
                .build();
    }
}
