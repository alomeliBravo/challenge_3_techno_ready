package com.pikolinc.googleschoolarapi.services;

import com.pikolinc.googleschoolarapi.entity.ArticleEntity;
import com.pikolinc.googleschoolarapi.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class ArticleService {
    private ArticleRepository articleRepository;

    public ArticleEntity saveArticle(ArticleEntity article){
        return articleRepository.save(article);
    }

    public List<ArticleEntity> getAllArticles(){
        return articleRepository.findAll();
    }

    public List<ArticleEntity> getArticlesByTitle(String title){
        return articleRepository.findByTitle(title);
    }

    public List<ArticleEntity> getArticleByTitleContaining(String title){
        return articleRepository.findByTitleContaining(title);
    }

    public List<ArticleEntity> getArticlesByAuthor(String author){
        return articleRepository.findByAuthor(author);
    }

    public ArticleEntity getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    public void deleteArticleById(Long id) {
        articleRepository.deleteById(id);
    }
}
