package com.steve.boot.launch.controller;

import com.steve.boot.launch.AjaxReponse;
import com.steve.boot.launch.model.ArticleVO;
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
        ArticleVO articleVO = articleService.getArticle(id);
        log.info("get a article:" + articleVO);
        return AjaxReponse.success(articleVO);
    }

    @GetMapping("/articles")
    public AjaxReponse getArticles(){
        List<ArticleVO> articleVOs = articleService.getAll();
        log.info("get a article:" + articleVOs);
        return AjaxReponse.success(articleVOs);
    }

    @PostMapping("/articles")
    public AjaxReponse addArticle(@RequestBody ArticleVO articleVO){
        articleService.saveArticle(articleVO);
        log.info("get a article:" + articleVO);
        return AjaxReponse.success(articleVO);
    }

    @PutMapping("/articles/{id}")
    public AjaxReponse updateArticle(@RequestBody ArticleVO articleVO){
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
