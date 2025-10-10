package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.List;
import java.util.Map;

/**
 * Mapper for converting API responses into {@link AuthorDTO} objects.
 */
public class AuthorDTOMapper {
    /**
     * Maps raw API response data to an {@link AuthorDTO}.
     *
     * @param apiResponse complete response from SerpAPI
     * @param authorId    unique ID of the author
     * @return mapped {@link AuthorDTO}
     */
    public static AuthorDTO mapToAuthorDTO(Map<String, Object> apiResponse, String authorId){
        Map<String, Object> author = (Map<String, Object>) apiResponse.get("author");

        return new AuthorDTO(
                AuthorDetailsDTOMapper.mapAuthorDetails(author,authorId),
                InterestDTOMapper.mapInterest((List<Map<String, Object>>) author.get("interests")),
                ArticlesDTOMapper.mapArticles((List<Map<String, Object>>) apiResponse.get("articles")),
                PublicAccessDTOMapper.mapPublicAccess((Map<String, Object>) apiResponse.get("public_access")),
                PaginationDTOMapper.mapPagination((Map<String, Object>) apiResponse.get("serpapi_pagination"))
        );

    }
}
