package me.yoon.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.yoon.springbootdeveloper.domain.Article;
import me.yoon.springbootdeveloper.dto.AddArticleRequest;
import me.yoon.springbootdeveloper.dto.UpdateArticleRequest;
import me.yoon.springbootdeveloper.repository.BlogRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request, String userName) {
        return blogRepository.save(request.toEntity(userName));
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    @Transactional
    public Article delete(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                        .orElseThrow(()->new IllegalArgumentException("not found: "+id));

        authorizeArticleAuthor(article);
        article.update(request.getTitle(), request.getContent());

        return article;
    }

    // 글쓴이 검증
    private static void authorizeArticleAuthor(Article article) {
        String userName = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        if(!article.getAuthor().equals(userName)) {
            throw new IllegalArgumentException("not authorized");
        }
    }

    @Transactional
    public Article update(long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: " + id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }

}
