package com.likelionking.LikeLionKingSbb.article.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ArticleForm {
    @NotEmpty(message = "제목은 필수항목입니다.")
    @Size(max = 200)
    private String title;

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;
}
