package com.likelionking.LikeLionKingSbb.article.dto;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private String title;
    private String content;

    public static Article toEntity(ArticleDto articleDto) {
        return Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .build();
    }
}
