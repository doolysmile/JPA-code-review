package com.example.LionKingJPA.domain.article.dto;

import com.example.LionKingJPA.domain.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {
    @NotEmpty(message = "제목은 필수항목입니다.")
    @Size(max = 200, message = "제목을 200자 이하로 입력해주세요.")
    private String title;
    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;

    public static Article toEntity(ArticleDto articleDto){
        return Article.builder()
                .title(articleDto.getTitle())
                .content(articleDto.getContent())
                .build();
    }
}
