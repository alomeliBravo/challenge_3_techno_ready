package com.pikolinc.googleschoolarapi.controllers;

import com.pikolinc.googleschoolarapi.entity.ArticleEntity;
import com.pikolinc.googleschoolarapi.services.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping
    public ArticleEntity createArticle(@RequestBody ArticleEntity article) {
        return articleService.saveArticle(article);
    }

    @GetMapping
    public List<ArticleEntity> getAllArticles(@RequestParam String title) {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ArticleEntity getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }
}
