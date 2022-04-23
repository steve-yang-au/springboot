package com.steve.boot.launch.controller;

import com.steve.boot.launch.AjaxReponse;
import com.steve.boot.launch.model.Article;
import com.steve.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restful")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @GetMapping("/articles/{id}")
    public AjaxReponse getArticle(@PathVariable("id") Long id){
        Article article = articleService.getArticle(id);
        log.info("get a article:" + article);
        return AjaxReponse.success(article);
    }

    @GetMapping("/articles")
    public AjaxReponse getArticles(){
        List<Article> articles = articleService.getAll();
        log.info("get a article:" + articles);
        return AjaxReponse.success(articles);
    }

    @PostMapping("/articles")
    public AjaxReponse addArticle(@RequestBody Article article){
        articleService.saveArticle(article);
        log.info("get a article:" + article);
        return AjaxReponse.success(article);
    }

    @PutMapping("/articles")
    public AjaxReponse updateArticle(@RequestBody Article article){
        articleService.updateArticle(article);
        log.info("get a article:" + article);
        return AjaxReponse.success();
    }

    @DeleteMapping("/articles/{id}")
    public AjaxReponse deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
        return AjaxReponse.success();
    }
}
