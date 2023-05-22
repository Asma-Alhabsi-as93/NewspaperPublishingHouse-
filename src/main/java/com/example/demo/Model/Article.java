package com.example.demo.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
@Data
@Setter
@Getter
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
     String title;
     String content;
     String author;
     Date publishDate;
    Boolean isActive;
    Boolean published;


}
