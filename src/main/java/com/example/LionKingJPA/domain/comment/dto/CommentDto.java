package com.example.LionKingJPA.domain.comment.dto;

import com.example.LionKingJPA.domain.article.entity.Article;
import com.example.LionKingJPA.domain.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;

    public static Comment toEntity(CommentDto commentDto, Article article) {
        return Comment.builder()
                .content(commentDto.content)
                .article(article)
                .build();
    }
}
