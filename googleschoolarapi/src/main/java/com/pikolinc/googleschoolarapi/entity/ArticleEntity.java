package com.pikolinc.googleschoolarapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "article")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String title;

    private String authors;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "abstract")
    private String abstract_;

    private String link;

    private String keywords;

    @Column(name = "cited_by")
    private Long citedBy;

}
