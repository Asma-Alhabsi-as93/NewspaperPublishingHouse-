package com.example.demo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Data
public class ArticleDTO {
    private String title;
    private String content;
    private String author;
    private Date publishDate;

    public ArticleDTO(String title, String content, String author, Date publishDate) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = publishDate;
    }
}
