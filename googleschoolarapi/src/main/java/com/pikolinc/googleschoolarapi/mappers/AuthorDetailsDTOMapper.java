package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.Map;

/**
 * Mapper for converting raw author data into {@link AuthorDTO.AuthorDetailsDTO}.
 */
public class AuthorDetailsDTOMapper {
    /**
     * Maps author details from a data map to an {@link AuthorDTO.AuthorDetailsDTO}.
     *
     * @param author map containing author information
     * @param id     author's unique ID
     * @return mapped {@link AuthorDTO.AuthorDetailsDTO}, or {@code null} if data is invalid
     */
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
