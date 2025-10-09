package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.Map;

public class AuthorDetailsDTOMapper {
    public static AuthorDTO.AuthorDetailsDTO mapAuthorDetails(Map<String,Object> author, String id) {
        if(author == null | id == null) return null;

        return new AuthorDTO.AuthorDetailsDTO(
                id,
                (String) author.get("name"),
                (String) author.get("affiliations"),
                (String) author.get("email"),
                (String) author.get("thumbnail")
        );
    }
}
