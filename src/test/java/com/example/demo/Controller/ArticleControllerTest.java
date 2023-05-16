package com.example.demo.Controller;

import com.example.demo.Model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ArticleControllerTest {
@Autowired
ArticleController articleController;
    @Test

    void getAllArticle() {
        List<Article> allCourseTest=articleController.getAllArticle();
        assertNotNull(allCourseTest);
    }

    @Test
    void getArticleById() {
        Article ArticleByIdTest=articleController.getArticleById(1);
        String title =ArticleByIdTest.getTitle();
        assertNotNull(ArticleByIdTest);
        assertEquals("New Movie Launching Soon",title);
        assertNotEquals("since",title);

    }

    @Test
    void deleteArticle() {
    }

    @Test
    void getByActive() {
        List <Article> activeTest=articleController.getByActive();
        assertNotNull(activeTest);
    }

    @Test
    void getByInActive() {
        List <Article> inActiveTest=articleController.getByInActive();
        assertNotNull(inActiveTest);
    }

    @Test
    void getArticleUpdatedDate() {
    }
}