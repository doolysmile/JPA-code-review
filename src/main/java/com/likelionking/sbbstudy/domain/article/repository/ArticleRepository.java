package com.likelionking.sbbstudy.domain.article.repository;


import com.likelionking.sbbstudy.domain.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
