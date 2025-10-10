package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;
import com.pikolinc.googleschoolarapi.entity.ArticleEntity;

import java.time.LocalDate;
/**
 * Mapper utility for converting {@link AuthorDTO} data into {@link ArticleEntity}.
 */
public class ArticleEntityMapper {
    /**
     * Maps an article from {@link AuthorDTO} to an {@link ArticleEntity} based on its position.
     *
     * @param authorDTO source data containing author and article info
     * @param position  index of the article to map
     * @return mapped {@link ArticleEntity}
     * @throws IllegalArgumentException if the position is invalid
     */
    public static ArticleEntity mapFromAuthorDTO(AuthorDTO authorDTO, int position){
        if(position > authorDTO.articles().size()){
            throw new  IllegalArgumentException("Not article at position");
        }

        AuthorDTO.ArticlesDTO articlesDTO = authorDTO.articles().get(position);

        return ArticleEntity.builder()
                .title(articlesDTO.title())
                .authors(articlesDTO.authors())
                .publicationDate(LocalDate.now())
                .abstract_("Not Abstract")
                .link(articlesDTO.link())
                .keywords("No keywords")
                .citedBy((long) articlesDTO.citedBy().value())
                .build();
    }
}
