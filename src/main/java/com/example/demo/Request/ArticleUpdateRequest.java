package com.example.demo.Request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
public class ArticleUpdateRequest {
    private String title;
    private String content;
    private String author;
    private Date publishDate;
}
