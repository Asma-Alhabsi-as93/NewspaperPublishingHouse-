package com.example.demo.Service;

import com.example.demo.DTO.ArticleDTO;
import com.example.demo.Model.Article;
import com.example.demo.Repositry.ArticleRepositry;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportService {
@Autowired
    ArticleRepositry articleRepositry;
    public static final String pathToReports ="C:\\Users\\User004\\Desktop\\newsepaperReport";
    public String generateReport() throws FileNotFoundException, JRException {
        List<Article> articleList = articleRepositry.getAllArticle();
        List<ArticleDTO> articleReportDTOS = new ArrayList<>();
        for (Article article:articleList) {
            article.getTitle();
            article.getContent();
            article.getAuthor();
            article.getPublishDate();
            ArticleDTO articleReportDTO = new ArticleDTO(article.getTitle(), article.getContent(), article.getAuthor(), article.getPublishDate());
            articleReportDTOS.add(articleReportDTO);
        }
        File file = ResourceUtils.getFile("C:\\NewspaperPublishingHouse--main\\src\\main\\resources\\Article.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(articleList);
        Map<String, Object> paramters = new HashMap<>();
        paramters.put("CreatedBy", "MyName");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramters, dataSource);
        JasperExportManager.exportReportToPdfFile(jasperPrint, pathToReports + "\\article.pdf");
        return "Report generated : " + pathToReports + "\\article.pdf";
    }


}


