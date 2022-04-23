package com.steve.boot.launch.service;

import com.steve.boot.launch.dao.ArticleJDBCDAO;
import com.steve.boot.launch.model.Article;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.List;

@Service
public class ArticleServiceJDBCImpl implements ArticleService{

    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Resource
    @Qualifier("primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    @Qualifier("secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate;

    @Override
    public void saveArticle(Article article) {
        articleJDBCDAO.saveArticle(article,primaryJdbcTemplate);
        articleJDBCDAO.saveArticle(article,secondaryJdbcTemplate);
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id,null);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        if(article.getId() == null){
            //TODO throw a exception defined by ourselves
        }
        //articleJDBCDAO.updateById(article);
        articleJDBCDAO.deleteById(article.getId(),null);
        articleJDBCDAO.saveArticle(article,null);
        int i = 10/0;

    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id,null);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll(null);
    }
}
