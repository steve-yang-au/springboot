package com.steve.boot.launch.service;

import com.steve.boot.launch.dao.ArticleJDBCDAO;
import com.steve.boot.launch.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.List;

@Service
public class ArticleServiceJDBCImpl implements ArticleService{

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Override
    public void saveArticle(Article article) {
        articleJDBCDAO.saveArticle(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        if(article.getId() == null){
            //TODO throw a exception defined by ourselves
        }
        //articleJDBCDAO.updateById(article);
        articleJDBCDAO.deleteById(article.getId());
        articleJDBCDAO.saveArticle(article);
        int i = 10/0;

    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
