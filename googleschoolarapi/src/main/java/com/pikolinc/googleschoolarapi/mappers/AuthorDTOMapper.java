package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.List;
import java.util.Map;

public class AuthorDTOMapper {
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
