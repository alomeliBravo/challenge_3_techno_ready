package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArticlesDTOMapper {
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
