package com.example.demo.Repositry;

import com.example.demo.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Repository
public interface ArticleRepositry extends JpaRepository<Article, Integer> {
    List<Article> findByPublishDateBeforeAndPublishedIsFalse(LocalDate currentDate);
    @Query(value = "SELECT s from Article s")
    List<Article> getAllArticle();

    @Query(value = "SELECT s from Article s where s.id =:articleId")
    Article getArticleById(@Param("articleId")Integer articleId);

    @Query(value = "Update Article c SET c.isActive=0  WHERE c.id = :id")
    void deleteArticle(@Param("id")Integer id);

    @Query(value = "SELECT s from Article s where s.isActive = 1")
    List<Article> getAllActiveArticle();

    @Query(value = "SELECT s from Article s where s.isActive = 0")
    List<Article> getAllInActiveArticle();
    @Query(value ="SELECT s from Article s where s.publishDate = :publishDate")
    List<Article> getArticleUpdatedDate(@Param("publishDate") Date publishDate);

}
