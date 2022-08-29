package com.example.LionKingJPA.domain.article.repository;

import com.example.LionKingJPA.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
