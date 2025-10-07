package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.Map;

public class CitedByDTOMapper {
    public static AuthorDTO.ArticlesDTO.CitedByDTO mapCitedBy(Map<String, Object> citedBy) {
        if(citedBy == null) return null;

        return new AuthorDTO.ArticlesDTO.CitedByDTO(
            (int) citedBy.get("value"),
            (String) citedBy.get("link")
        );
    }
}
