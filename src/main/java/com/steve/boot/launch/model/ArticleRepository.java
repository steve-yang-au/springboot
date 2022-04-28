package com.steve.boot.launch.dao.db1;

import com.steve.boot.launch.dao.db1.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByAuthor(String author);
}
