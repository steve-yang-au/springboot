package com.steve.boot.launch.dao;

import com.steve.boot.launch.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ArticleJDBCDAO {

    @Resource
    private JdbcTemplate jdbcTemplate;

    //save an article
    public void saveArticle(Article article){
        jdbcTemplate.update("INSERT INTO article(author, title, content, create_time) VALUES (?,?,?,?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

    //delete an article
    public void deleteById(Long id){
        jdbcTemplate.update("DELETE FROM article WHERE id=?", id);
    }

    //update an article
    public void updateById(Article article){
        jdbcTemplate.update("UPDATE article SET author=?,title=?,content=?, create_time=? WHERE id=?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }

    //find an article
    public Article findById(Long id){
        return jdbcTemplate.queryForObject("SELECT * FROM article WHERE id=?",
                new BeanPropertyRowMapper<>(Article.class), new Object[]{id});
    }

    //find list of Articles
    public List<Article> findAll(){
        return (List<Article>) jdbcTemplate.query("SELECT * FROM article",
                new BeanPropertyRowMapper<>(Article.class));
    }
}
