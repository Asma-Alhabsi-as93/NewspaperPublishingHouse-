package com.example.demo.Controller;

import com.example.demo.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "articleDTO")
public class ReportController {
    @Autowired
    ReportService reportService;
    @GetMapping(value = "getArticleDTO")
    public void ArticleDTO() throws Exception {
        reportService.generateReport();
    }
}
