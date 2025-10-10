package com.pikolinc.googleschoolarapi.repository;

import com.pikolinc.googleschoolarapi.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for {@link ArticleEntity}.
 * <p>
 * Provides CRUD operations and custom queries for articles.
 * </p>
 */
@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
    /**
     * Finds articles with the specified title.
     *
     * @param title article title
     * @return list of matching articles
     */
    List<ArticleEntity> findByTitle(String title);

    /**
     * Finds articles that contain the given author.
     *
     * @param authors author name or substring
     * @return list of matching articles
     */
    List<ArticleEntity> findByAuthorsContaining(String authors);
}
