package com.steve.boot.lauch.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Article {
    private Long id;
    private String title;
    private String content;
    private String author;
    private Date createTime;
    private List<Reader> readers;
}
