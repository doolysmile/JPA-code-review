package com.likelionking.sbbstudy.domain.domain;

import com.likelionking.sbbstudy.domain.article.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class CommentForm {

    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;

    private Article article;

    public static Comment toEntity(CommentForm commentForm) {
        return Comment.builder()
                .content(commentForm.getContent())
                .article(commentForm.getArticle())
                .build();
    }

}
