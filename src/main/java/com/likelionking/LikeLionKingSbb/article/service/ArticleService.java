package com.likelionking.LikeLionKingSbb.article.service;

import com.likelionking.LikeLionKingSbb.ArticleLike.domain.ArticleLike;
import com.likelionking.LikeLionKingSbb.article.domain.Article;
import com.likelionking.LikeLionKingSbb.article.dto.ArticleDto;
import com.likelionking.LikeLionKingSbb.article.repository.ArticleRepository;
import com.likelionking.LikeLionKingSbb.exception.DataNotFoundException;
import com.likelionking.LikeLionKingSbb.user.domain.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;


    public Page<Article> getList(int page) {
        int size = 10;
        Sort sort = Sort.by("id").descending();

        // 조회할 page, 가져올 아이템 개수, 정렬 방식
        // Pageable의 구현체 = PageRequest
        Pageable pageable = PageRequest.of(page, size, sort);

        return articleRepository.findAll(pageable);
    }

    public Article getDetail(Long articleId) {
        return findById(articleId);
    }

    public Article findById(Long articleId) {
        // 예외처리
        return articleRepository.findById(articleId).orElseThrow(() -> {
            throw new DataNotFoundException("article not found");
        });
    }

    public Long create(ArticleDto articleDto, SiteUser author) {
        Article article = ArticleDto.toEntity(articleDto, author);
        Article saveArticle = articleRepository.save(article);

        return saveArticle.getId();
    }

    public void modify(Article article, ArticleDto articleDto) {
        article.modify(articleDto);
//        article.setTitle(articleDto.getTitle());
//        article.setContent(articleDto.getContent());

        articleRepository.save(article);
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }

    // TODO: Transactional 붙여야 add 반영됨!
    @Transactional
    public void like(Article article, SiteUser siteUser) {
        ArticleLike articleLike = ArticleLike.builder()
                .article(article)
                .voter(siteUser)
                .build();

        article.getArticleLikeList().add(articleLike);
    }
}
