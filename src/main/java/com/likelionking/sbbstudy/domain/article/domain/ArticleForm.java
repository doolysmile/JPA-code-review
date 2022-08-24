package com.likelionking.sbbstudy.domain.article.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
public class ArticleForm {

    @NotEmpty(message = "제목을 입력해주세요.")
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
