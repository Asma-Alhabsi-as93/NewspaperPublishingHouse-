package com.example.demo.Controller;

import com.example.demo.Model.Article;
import com.example.demo.Request.ArticleRequest;
import com.example.demo.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "article")
public class ArticleController {
    @Autowired
    ArticleService articleService;


    @RequestMapping(value = "addArticle", method = RequestMethod.POST)
    public String addAccount(@RequestBody ArticleRequest articleRequest) {
        try {
            articleService.addArticle(articleRequest);
            return "Article added Successfully";
        } catch (Exception e) {
            return "Article added Failed";
        }
    }

    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<Article> getAllArticle() {

        List<Article> articles = articleService.getAllArticle();
        return articles;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Article getArticleById(@RequestParam Integer articleId) {
        Article article = articleService.getArticleById(articleId);
        return article;
    }

    @RequestMapping(value = "deleteArticle", method = RequestMethod.POST)
    public String deleteArticle(Integer id) {
        try {
            articleService.deleteArticle(id);
            return "Article deleted Successfully";

        } catch (Exception e) {
            return "Article delete failed";
        }

    }

    @RequestMapping(value = "getByActive")
    public List<Article> getByActive() {
        List<Article> activeArticleList = articleService.getByActive();
        return activeArticleList;
    }

    @RequestMapping(value = "getByInActive")
    public List<Article> getByInActive() {
        List<Article> activeArticleList = articleService.getByInActive();
        return activeArticleList;
    }

    @RequestMapping(value = "getArticleUpdatedDate", method = RequestMethod.POST)
    public List<Article> getArticleUpdatedDate(@RequestParam String publishDate) throws ParseException {
        List<Article> articles = articleService.getArticleUpdatedDate(publishDate);
        return articles;
    }

}
