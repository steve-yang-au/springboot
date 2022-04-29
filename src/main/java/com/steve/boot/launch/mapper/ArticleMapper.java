package com.steve.boot.launch.mapper;

import java.util.List;

public interface ArticleMapper {
    public void saveArticle(Article article);
    void deleteArticle(Long id);
    void updateArticle(Article article);
    Article getArticle(Long id);
    List<Article> getAll();
}
