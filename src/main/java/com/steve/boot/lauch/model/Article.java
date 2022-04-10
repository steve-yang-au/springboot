package com.steve.boot.lauch.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Article {
    @JsonIgnore
    private Long id;
    private String title;
    private String content;
    @JsonProperty("auther")
    private String author;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", timezone = "GMT+10")
    private Date createTime;
    private List<Reader> readers;
}
