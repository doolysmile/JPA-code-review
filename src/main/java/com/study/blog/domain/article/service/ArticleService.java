package com.study.blog.domain.article.service;

import com.study.blog.common.exception.ArticleNotFoundException;
import com.study.blog.domain.article.domain.Article;
import com.study.blog.domain.article.repository.ArticleRepository;
import com.study.blog.domain.member.domain.Member;
import com.study.blog.domain.member.domain.dto.MemberDto;
import com.study.blog.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final MemberRepository memberRepository;
    public List<Article> getList() {
        return articleRepository.findAll();
    }

    public Article getArticle(long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article
                .orElseThrow(() -> new ArticleNotFoundException("%d번 게시글은 존재하지 않습니다.".formatted(id)));
    }

    public void create(String title, String content, String memberName) {
        Member member = memberRepository.findByMemberName(memberName).orElseThrow();

        Article article = new Article();
        article.setCreateDate(LocalDateTime.now());
        article.setTitle(title);
        article.setAuthor(member);
        article.setContent(content);

        articleRepository.save(article);
    }
}
