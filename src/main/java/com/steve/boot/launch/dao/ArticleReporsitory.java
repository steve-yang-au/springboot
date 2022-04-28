package com.steve.boot.launch.dao;

import com.steve.boot.launch.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleReporsitory extends JpaRepository<Article, Long> {

}
