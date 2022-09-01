package com.likelionking.LikeLionKingSbb.article.dto;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class ArticleForm {
    @NotEmpty(message = "제목은 필수항목입니다.")
    @Size(max = 200)
    private String title;

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;

    public static Article toEntity(ArticleForm articleForm) {
        return Article.builder()
                .title(articleForm.getTitle())
                .content(articleForm.getContent())
                .build();
    }
}
