package com.steve.boot.launch.controller;

import com.steve.boot.launch.AjaxReponse;
import com.steve.boot.launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/restful")
public class ArticleController {
    @GetMapping("/articles/{id}")
    public AjaxReponse getArticle(@PathVariable("id") Long id){
        Article article = Article.builder()
                .id(1L)
                .author("Steve")
                .content("learn how to code in java")
                .title("Spring boot")
                .createTime(new Date())
                .build();
        log.info("get a article:" + article);
        return AjaxReponse.success(article);
    }

    @PostMapping("/articles")
    public AjaxReponse addArticle(@RequestBody Article article){
        log.info("get a article:" + article);
        return AjaxReponse.success(article);
    }

    @PutMapping("/articles/{id}")
    public AjaxReponse updateArticle(@RequestBody Article article){
        if(article.getId() == null){
            //TODO throw a exception
        }
        log.info("get a article:" + article);
        return AjaxReponse.success();
    }

    @DeleteMapping("/articles/{id}")
    public AjaxReponse deleteArticle(@PathVariable("id") Long id){
        if(id == null){
            //TODO throw a exception
        }
        return AjaxReponse.success();
    }
}
