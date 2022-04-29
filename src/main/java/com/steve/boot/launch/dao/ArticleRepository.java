package com.steve.boot.launch.dao;

import com.steve.boot.launch.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "zzs")
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByAuthor(String author);
}
