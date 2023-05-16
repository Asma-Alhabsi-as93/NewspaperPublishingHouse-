package com.example.demo.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class ArticleRequest {
    private String title;
    private String content;
    private String author;
    private Date publishDate;
    private Boolean isActive;
    Boolean published;
}
