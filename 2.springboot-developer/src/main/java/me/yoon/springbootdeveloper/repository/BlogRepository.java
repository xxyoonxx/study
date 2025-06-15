package me.yoon.springbootdeveloper.repository;

import me.yoon.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {



}
