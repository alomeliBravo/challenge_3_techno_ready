package com.pikolinc.googleschoolarapi.dto;

import java.util.List;

public record AuthorDTO(
    AuthorDetailsDTO author,
    List<InterestDTO> interests,
    List<ArticlesDTO> articles,
    PublicAccessDTO publicAccess,
    PaginationDTO pagination
) {
    public record AuthorDetailsDTO(
        String name,
        String affiliations,
        String email,
        String thumbnail
    ){}

    public record InterestDTO(
        String title,
        String link
    ){}

    public record ArticlesDTO(
        String title,
        String link,
        String citationId,
        String authors,
        String publication,
        CitedByDTO citedBy,
        String year
    ){
        public record CitedByDTO(
            int value,
            String link
        ){}
    }

    public record PublicAccessDTO(
        String link,
        int available,
        int notAvailable
    ){}

    public record PaginationDTO(
        String next
    ){}
}

