package com.steve.boot.launch;

import com.steve.boot.launch.dao.db1.Article;
import com.steve.boot.launch.dao.db1.ArticleRepository;
import com.steve.boot.launch.dao.db2.Message;
import com.steve.boot.launch.dao.db2.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class JPAKeyWordTest {
    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;
    @Test
    public void jpsTest(){
        Article article = articleRepository.findByAuthor("Steve");
        System.out.println(article);
    }

    @Test
    public void jpsTest2(){
        Article article = Article.builder()
                .id(1L)
                .author("Steve")
                .content("learn how to code in java")
                .title("Spring boot")
                .createTime(new Date())
                .build();

        Message message = Message.builder()
                .id(2L)
                .name("mes")
                .content("sage")
                .build();
        articleRepository.save(article);
        messageRepository.save(message);
    }
}
