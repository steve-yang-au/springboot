package com.steve.boot.launch;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steve.boot.launch.dao.mapper.Article;
import com.steve.boot.launch.model.Reader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JacksonTest {
    @Test
    public void testJackson() throws JsonProcessingException {
        List<Reader> list = new ArrayList<>();
        list.add(new Reader("Paige",23));
        list.add(new Reader("Buck",24));
        Article article = Article.builder()
                .id(2L)
                .title("hha")
                .content("testing for Jackson")
                .author("Joss")
                .createTime(new Date())
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(article);
        System.out.println(json);

    }
}
