package com.steve.boot.launch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "data structure of an article ")
public class ArticleVO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;
    private String title;
    private String content;
    @JsonProperty("auther")
    private String author;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT+10")
    private Date createTime;
    private List<Reader> readers;
}
