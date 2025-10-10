package com.pikolinc.googleschoolarapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Entity representing an article in the database.
 */
@Entity
@Table(name = "article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity {

    /**
     * Unique identifier for the article.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    /**
     * Title of the article.
     */
    @Column(nullable = false)
    private String title;

    /**
     * Authors of the article.
     */
    private String authors;

    /**
     * Date of publication.
     */
    @Column(name = "publication_date")
    private LocalDate publicationDate;

    /**
     * Abstract of the article.
     */
    @Column(name = "abstract")
    private String abstract_;

    /**
     * Link to the article.
     */
    private String link;

    /**
     * Keywords associated with the article.
     */
    private String keywords;

    /**
     * Number of citations the article has received.
     */
    @Column(name = "cited_by")
    private Long citedBy;

}
