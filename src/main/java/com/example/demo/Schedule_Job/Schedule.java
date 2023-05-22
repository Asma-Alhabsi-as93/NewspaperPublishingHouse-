package com.example.demo.Schedule_Job;

import com.example.demo.Model.Article;
import com.example.demo.Repositry.ArticleRepositry;
import com.example.demo.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.List;

@Component
public class Schedule {
    @Autowired
    ArticleRepositry articleRepositry;
    @Scheduled(cron = "0 0 0 * * *") // Run at midnight every day
    public void updatePublishedStatus() {
        LocalDate currentDate = LocalDate.now();
        List<Article> articles = articleRepositry.findByPublishDateBeforeAndPublishedIsFalse(currentDate);

        for (Article article : articles) {
            article.setPublished(true);
            articleRepositry.save(article);
        }
    }

}
