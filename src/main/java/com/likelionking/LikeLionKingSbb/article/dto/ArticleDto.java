package com.likelionking.LikeLionKingSbb.article.dto;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    private String title;
    private String content;

    public static Article toEntity(ArticleDto articleDto, SiteUser author) {
        return Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .author(author)
                .build();
    }
}
