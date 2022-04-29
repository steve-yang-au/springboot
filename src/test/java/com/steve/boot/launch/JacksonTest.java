package com.steve.boot.launch;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.steve.boot.launch.model.ArticleVO;
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
        ArticleVO articleVO = ArticleVO.builder()
                .id(2L)
                .title("hha")
                .content("testing for Jackson")
                .author("Joss")
                .createTime(new Date())
                .readers(list)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(articleVO);
        System.out.println(json);

        ArticleVO a = mapper.readValue("{\"title\":\"hha\",\"content\":\"testing for Jackson\",\"createTime\":\"11/04/2022 01:29:30\",\"readers\":[{\"name\":\"Paige\",\"age\":23},{\"name\":\"Buck\",\"age\":24}],\"auther\":\"Joss\"}", ArticleVO.class);
        System.out.println(a);
    }
}
