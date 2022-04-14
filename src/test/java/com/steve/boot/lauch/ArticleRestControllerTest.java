package com.steve.boot.lauch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steve.boot.lauch.controller.ArticleController;
import com.steve.boot.lauch.model.Article;
import com.steve.boot.lauch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import java.nio.charset.StandardCharsets;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//these two annotation is offered by Spring framework
@WebMvcTest(ArticleController.class) //only load those beans that related, the speed of execution is faster than @SpringBootTest
@AutoConfigureMockMvc

//offered by Junit
@ExtendWith(SpringExtension.class)

//offered by Lombok
@Slf4j

public class ArticleRestControllerTest {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    /**
     * @BeforeAll
     *     static void setUp(){
     *         mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
     *     }
     */

    @Test
    public void saveArticle() throws Exception {
        String article = " {" +
                "        \"title\": \"Spring Boot\",\n" +
                "        \"content\": \"learn how to code in java\",\n" +
                "        \"auther\": \"Steve Handsome\",\n" +
                "        \"createTime\": \"2021/04/15 02:41:53\",\n" +
                "        \"readers\": [{\"name\":\"John\",\"age\":22},{\"name\":\"Adam\",\"age\":43}]\n" +
                "    }";
        ObjectMapper mapper = new ObjectMapper();
        Article articleObj = mapper.readValue(article,Article.class);

        //set a mocking condition for those service beans that has not written up by other developers or can not be used for some reasons
        when(articleService.saveArticle(articleObj)).thenReturn("ok");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .request(HttpMethod.POST, "/restful/articles")
                .contentType("application/json")
                .content(article)
        )
        .andExpect(MockMvcResultMatchers.status().isOk()) // HTTP status 200
        .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok"))
        .andDo(print())
        .andReturn();

        log.info(mvcResult.getResponse().getContentAsString());

        /**
         * the API for Mockito
         */

        /**
         * mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}", "userId"));
         *         mockMvc.perform(MockMvcRequestBuilders.multipart("uri").file("filename","file".getBytes(StandardCharsets.UTF_8)));
         *         mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}").sessionAttr("name","value"));
         *         mockMvc.perform(MockMvcRequestBuilders.get("/user/{id}").cookie(new Cookie("name","value")));
         *         //setting HTTP Header
         *         mockMvc.perform(MockMvcRequestBuilders
         *                 .request(HttpMethod.GET, "/user/{id}")
         *                 .contentType("application/json")
         *                 .accept("application/json")
         *                 .header("",""));
         */

    }
}
