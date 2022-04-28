package com.steve.boot.launch.controller;

import com.steve.boot.launch.AjaxReponse;
import com.steve.boot.launch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@RestController
@RequestMapping("/restful")
public class ArticleController {
    @GetMapping("/articles/{id}")
    public AjaxReponse getArticle(@PathVariable("id") Long id){
        ArticleVO articleVO = ArticleVO.builder()
                .id(1L)
                .author("Steve")
                .content("learn how to code in java")
                .title("Spring boot")
                .createTime(new Date())
                .build();
        log.info("get a article:" + articleVO);
        return AjaxReponse.success(articleVO);
    }

    @PostMapping("/articles")
    public AjaxReponse addArticle(@RequestBody ArticleVO articleVO){
        log.info("get a article:" + articleVO);
        return AjaxReponse.success(articleVO);
    }

    @PutMapping("/articles/{id}")
    public AjaxReponse updateArticle(@RequestBody ArticleVO articleVO){
        if(articleVO.getId() == null){
            //TODO throw a exception
        }
        log.info("get a article:" + articleVO);
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
