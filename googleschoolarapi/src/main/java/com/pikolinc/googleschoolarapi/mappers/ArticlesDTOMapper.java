package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Mapper for converting raw article data from API responses into {@link AuthorDTO.ArticlesDTO} objects.
 */
public class ArticlesDTOMapper {
    /**
     * Maps a list of article data maps to a list of {@link AuthorDTO.ArticlesDTO}.
     *
     * @param articles list of maps representing article data
     * @return list of mapped {@link AuthorDTO.ArticlesDTO}, or an empty list if input is null
     */
    public static List<AuthorDTO.ArticlesDTO> mapArticles(List<Map<String, Object>> articles) {
        if(articles == null) return List.of();

        return articles.stream()
            .map(article -> {
                Map<String,Object> citedBy = (Map<String,Object>) article.get("cited_by");
                return new AuthorDTO.ArticlesDTO(
                        (String) article.get("title"),
                        (String) article.get("link"),
                        (String) article.get("citation_id"),
                        (String) article.get("authors"),
                        (String) article.get("publication"),
                        citedBy != null ? CitedByDTOMapper.mapCitedBy(citedBy) : null,
                        (String) article.get("year")
                );
            })
            .collect(Collectors.toList());
    }
}
