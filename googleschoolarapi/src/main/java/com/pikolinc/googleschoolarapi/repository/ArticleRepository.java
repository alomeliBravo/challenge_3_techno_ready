package com.pikolinc.googleschoolarapi.repository;

import com.pikolinc.googleschoolarapi.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    List<ArticleEntity> findByTitle(String title);

    List<ArticleEntity> findByTitleContaining(String keyword);

    List<ArticleEntity> findByAuthor(String author);
}
