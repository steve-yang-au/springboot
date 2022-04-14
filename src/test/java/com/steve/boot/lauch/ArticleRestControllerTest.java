package com.steve.boot.lauch;

import com.steve.boot.lauch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
public class ArticleRestControllerTest {
    private static MockMvc mockMvc;

    @BeforeAll
    static void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    @Test
    public void saveArticle() throws Exception {
        String article = " {" +
                "        \"title\": \"Spring Boot\",\n" +
                "        \"content\": \"learn how to code in java\",\n" +
                "        \"auther\": \"Steve Handsome\",\n" +
                "        \"createTime\": \"2021/04/15 02:41:53\",\n" +
                "        \"readers\": [{\"name\":\"John\",\"age\":22},{\"name\":\"Adam\",\"age\":43}]\n" +
                "    }";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .request(HttpMethod.POST, "/restful/articles")
                .contentType("application/json")
                .content(article)
        )
        .andExpect(MockMvcResultMatchers.status().isOk()) // HTTP status 200
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.auther").value("Steve Handsome"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[1].age").value(43))
        .andDo(print())
        .andReturn();

        log.info(mvcResult.getResponse().getContentAsString());
    }
}
