package com.steve.boot.launch.service;

import com.steve.boot.launch.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ArticleService {

    public void saveArticle(Article article);
    void deleteArticle(Long id);
    void updateArticle(Article article);
    Article getArticle(Long id);
    List<Article> getAll();

}
