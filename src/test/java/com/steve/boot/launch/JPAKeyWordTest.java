package com.steve.boot.launch;

import com.steve.boot.launch.dao.ArticleRepository;
import com.steve.boot.launch.model.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JPAKeyWordTest {
    @Resource
    private ArticleRepository articleRepository;
    @Test
    public void jpsTest(){
        Article article = articleRepository.findByAuthor("Steve");
        System.out.println(article);
    }
}
