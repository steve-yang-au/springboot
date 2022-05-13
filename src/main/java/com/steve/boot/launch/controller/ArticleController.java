package com.steve.boot.launch.controller;

import com.steve.boot.launch.exception.AjaxReponse;
import com.steve.boot.launch.model.ArticleVO;
import com.steve.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/restful")
public class ArticleController {

    @Resource
    ArticleService articleService;

    @GetMapping("/articles/{id}")
    public ArticleVO getArticle(@PathVariable("id") Long id){
        ArticleVO articleVO = articleService.getArticle(id);
        log.info("get a article:" + articleVO);
        return articleVO;
    }

    @GetMapping("/articles")
    public List<ArticleVO> getArticles(){
        List<ArticleVO> articles = articleService.getAll();
        log.info("get a article:" + articles);
        return articles;
    }

    @PostMapping("/articles")
    public AjaxReponse addArticle(@Valid @RequestBody ArticleVO articleVO){
        articleService.saveArticle(articleVO);
        log.info("get a article:" + articleVO);
        return  AjaxReponse.success();
    }

    @PutMapping("/articles")
    public AjaxReponse updateArticle(@Valid @RequestBody ArticleVO articleVO){
        articleService.updateArticle(articleVO);
        log.info("get a article:" + articleVO);
        return AjaxReponse.success();
    }

    @DeleteMapping("/articles/{id}")
    public AjaxReponse deleteArticle(@PathVariable("id") Long id){
        articleService.deleteArticle(id);
        return AjaxReponse.success();
    }
}
