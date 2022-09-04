package com.likelionking.sbbstudy.domain.article.dto;

import com.likelionking.sbbstudy.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class ArticleForm {

    @NotEmpty(message = "제목을 입력해주세요.")
    @Size(max = 200)
    private String title;

    @NotEmpty(message = "내용을 입력해주세요.")
    private String content;

    public static Article toEntity(ArticleForm articleForm) {
        return Article.builder()
                .title(articleForm.getTitle())
                .content(articleForm.getContent())
                .build();
    }
}
