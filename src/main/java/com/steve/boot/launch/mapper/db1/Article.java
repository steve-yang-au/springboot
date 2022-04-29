package com.steve.boot.launch.mapper.db1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 32)
    private String title;

    @Column(nullable = false, length = 512)
    private String content;

    @Column(nullable = false, length = 32)
    private String author;

    @Column(nullable = false)
    private Date createTime;

    @Column
    private Date updateTime;
}
