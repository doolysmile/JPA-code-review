package com.likelionking.LikeLionKingSbb.comment.dto;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private String content;
    // TODO: article 넣어야 하는지 빼야하는지
//    private Article article;

    public static Comment toEntity(CommentDto commentDto, Article article) {
        return Comment.builder()
                .content(commentDto.getContent())
                .article(article)
                .build();
    }
}
