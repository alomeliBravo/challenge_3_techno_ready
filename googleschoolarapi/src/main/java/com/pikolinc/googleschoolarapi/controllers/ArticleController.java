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

    @PostMapping("/{authorId}/{position}")
    public ArticleEntity createArticle(@PathVariable String authorId, @PathVariable int position) {
        return articleService.saveArticle(authorId, position);
    }

    @GetMapping("/")
    public List<ArticleEntity> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public ArticleEntity getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    @GetMapping("/title/{title}")
    public List<ArticleEntity> getArticlesByTitle(@PathVariable String title) {
        return articleService.getArticlesByTitle(title);
    }

    @GetMapping("/author/{author}")
    public List<ArticleEntity> getArticlesByAuthor(@PathVariable String author) {
        return articleService.getArticlesByAuthor(author);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }
}
