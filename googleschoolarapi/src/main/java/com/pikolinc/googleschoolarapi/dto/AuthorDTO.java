package com.pikolinc.googleschoolarapi.dto;

import java.util.List;

/**
 * Data Transfer Object representing an author and related information.
 */
public record AuthorDTO(
    AuthorDetailsDTO author,
    List<InterestDTO> interests,
    List<ArticlesDTO> articles,
    PublicAccessDTO publicAccess,
    PaginationDTO pagination
) {
    /**
     * Basic details of an author.
     */
    public record AuthorDetailsDTO(
        String authorId,
        String name,
        String affiliations,
        String email,
        String thumbnail
    ){}

    /**
     * Represents a topic of interest for the author.
     */
    public record InterestDTO(
        String title,
        String link
    ){}

    /**
     * Represents an article authored by the author.
     */
    public record ArticlesDTO(
        String title,
        String link,
        String citationId,
        String authors,
        String publication,
        CitedByDTO citedBy,
        String year
    ){
        /**
         * Citation information for the article.
         */
        public record CitedByDTO(
            int value,
            String link
        ){}
    }

    /**
     * Public access information for the author's articles.
     */
    public record PublicAccessDTO(
        String link,
        int available,
        int notAvailable
    ){}

    /**
     * Pagination information for API responses.
     */
    public record PaginationDTO(
        String next
    ){}
}

