package com.example.LionKingJPA.domain.article.dto;

import com.example.LionKingJPA.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private String title;

    private String content;

    public static Article toEntity(ArticleDto articleDto){
        return Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .build();
    }
}
