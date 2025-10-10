package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;
import com.pikolinc.googleschoolarapi.entity.ArticleEntity;

import java.time.LocalDate;

public class ArticleEntityMapper {
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
