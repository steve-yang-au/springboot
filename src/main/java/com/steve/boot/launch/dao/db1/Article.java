package com.steve.boot.launch.dao.db1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "article")
@EntityListeners(AuditingEntityListener.class)
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
    @CreatedDate
    private Date createTime;

    @Column
    @LastModifiedDate
    private Date updateTime;
}
