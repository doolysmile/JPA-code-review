package com.likelionking.LikeLionKingSbb.comment.dto;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.comment.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

// TODO: 안붙이면 오류난다..
@Getter
@Setter
@AllArgsConstructor
public class CommentForm {
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;

    public static Comment toEntity(CommentForm commentForm, Article article) {
        return Comment.builder()
                .content(commentForm.content)
                .article(article)
                .build();
    }
}
