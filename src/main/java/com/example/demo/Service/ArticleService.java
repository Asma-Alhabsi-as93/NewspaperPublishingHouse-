package com.example.demo.Service;

import com.example.demo.Model.Article;
import com.example.demo.Repositry.ArticleRepositry;
import com.example.demo.Request.ArticleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepositry articleRepositry;
    public Article addArticle(ArticleRequest articleRequest) {
        Article article = new Article();
        article.setTitle(articleRequest.getTitle());
        article.setContent(articleRequest.getContent());
        article.setAuthor(articleRequest.getAuthor());
        article.setPublishDate(articleRequest.getPublishDate());
        article.setIsActive(articleRequest.getIsActive());
        return articleRepositry.save(article);
    }
    public List<Article> getAllArticle() {
        return articleRepositry.getAllArticle();
    }
    public Article getArticleById(Integer articleId) {
        Article article = articleRepositry.getArticleById(articleId);
        return article;
    }
     public void deleteArticle(Integer id) {
        Article article = articleRepositry.findById(id).get();
        article.setIsActive(Boolean.valueOf("false"));
        articleRepositry.save(article);
    }
    public List<Article> getByActive() {
        return articleRepositry.getAllActiveArticle();

    }

    public List<Article> getByInActive() {
        return articleRepositry.getAllInActiveArticle();

    }
    public List<Article> getArticleUpdatedDate(String date) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.fffffff");
        Date convertedDateFromStringToDateFormat = formatter.parse(date);
        List<Article>articles = articleRepositry.getArticleUpdatedDate(convertedDateFromStringToDateFormat);
        return articles;
    }

}
