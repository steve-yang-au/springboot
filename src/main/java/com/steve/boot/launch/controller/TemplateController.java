package com.steve.boot.launch.controller;

import com.steve.boot.launch.exception.CustomException;
import com.steve.boot.launch.exception.CustomExceptionType;
import com.steve.boot.launch.exception.ModelView;
import com.steve.boot.launch.model.ArticleVO;
import com.steve.boot.launch.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class TemplateController {

    @Resource
    ArticleService articleService;

    @GetMapping("/articles")
    @ModelView
    public String index(Model model){
        if(1==1) {
            throw CustomException.defaultCustomException(CustomExceptionType.USER_INPUT_ERROR);
        }
        List<ArticleVO> articles = articleService.getAll();
        model.addAttribute("articles", articles);
        return "index";
    }
}
