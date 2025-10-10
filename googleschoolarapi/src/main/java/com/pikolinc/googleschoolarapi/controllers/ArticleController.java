package com.pikolinc.googleschoolarapi.controllers;

import com.pikolinc.googleschoolarapi.entity.ArticleEntity;
import com.pikolinc.googleschoolarapi.services.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing {@link ArticleEntity} resources.
 * <p>
 * Provides endpoints to create, retrieve, and delete articles.
 * </p>
 */
@RestController
@RequestMapping("/articles")
class ArticleController {
    private final ArticleService articleService;

    /**
     * Injects the {@link ArticleService}.
     *
     * @param articleService service layer for article operations
     */
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * Creates and saves an article from the specified author and position.
     *
     * @param authorId author's ID
     * @param position article's position
     * @return saved {@link ArticleEntity}
     */
    @PostMapping("/{authorId}/{position}")
    public ArticleEntity createArticle(@PathVariable String authorId, @PathVariable int position) {
        return articleService.saveArticle(authorId, position);
    }

    /**
     * Retrieves all stored articles.
     *
     * @return list of {@link ArticleEntity}
     */
    @GetMapping("/")
    public List<ArticleEntity> getAllArticles() {
        return articleService.getAllArticles();
    }

    /**
     * Retrieves an article by its ID.
     *
     * @param id article ID
     * @return {@link ArticleEntity} if found
     */
    @GetMapping("/{id}")
    public ArticleEntity getArticleById(@PathVariable Long id) {
        return articleService.getArticleById(id);
    }

    /**
     * Retrieves articles with a specific title.
     *
     * @param title article title
     * @return list of matching {@link ArticleEntity}
     */
    @GetMapping("/title/{title}")
    public List<ArticleEntity> getArticlesByTitle(@PathVariable String title) {
        return articleService.getArticlesByTitle(title);
    }

    /**
     * Retrieves articles written by a specific author.
     *
     * @param author author name
     * @return list of matching {@link ArticleEntity}
     */
    @GetMapping("/author/{author}")
    public List<ArticleEntity> getArticlesByAuthor(@PathVariable String author) {
        return articleService.getArticlesByAuthor(author);
    }

    /**
     * Deletes an article by its ID.
     *
     * @param id article ID
     */
    @DeleteMapping("/{id}")
    public void deleteArticleById(@PathVariable Long id) {
        articleService.deleteArticleById(id);
    }
}
