package me.yoon.springbootdeveloper.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.yoon.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

@Getter
public class ArticleViewResponse {
    
    // 블로그 글 조회
    
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String author;

    public ArticleViewResponse() {
        this.createdAt = LocalDateTime.now();
    }

    public ArticleViewResponse(Article article) {
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.createdAt = article.getCreatedAt();
        this.author = article.getAuthor();
    }
}
