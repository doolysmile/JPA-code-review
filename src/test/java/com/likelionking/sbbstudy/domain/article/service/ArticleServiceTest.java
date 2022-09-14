package com.likelionking.sbbstudy.domain.article.service;

import com.likelionking.sbbstudy.domain.article.dto.ArticleForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    void pageTest(){
        for(int i = 0; i < 200; i++){
            String title = "테스트 데이터 : %03d".formatted(i);
            String content = "내용";
            ArticleForm articleForm = new ArticleForm(title, content);

//            articleService.write(articleForm);
        }
    }


}