package com.likelionking.LikeLionKingSbb.article.repository;

import com.likelionking.LikeLionKingSbb.article.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
