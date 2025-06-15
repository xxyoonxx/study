package me.yoon.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.yoon.springbootdeveloper.domain.Article;

import java.time.LocalDateTime;

// RestController를 통해 전달받는 객체는 아래의 세 개를 가지고 있어야함
@RequiredArgsConstructor
@Getter
public class AddArticleRequest {

    private final String title;
    private final String content;

    public Article toEntity(String author) {
        return Article.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}