package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.Map;

/**
 * Mapper for converting citation data into {@link AuthorDTO.ArticlesDTO.CitedByDTO}.
 */
public class CitedByDTOMapper {
    /**
     * Maps citation details from a data map to a {@link AuthorDTO.ArticlesDTO.CitedByDTO}.
     *
     * @param citedBy map containing citation information
     * @return mapped {@link AuthorDTO.ArticlesDTO.CitedByDTO}, or {@code null} if input is null
     */
    public static AuthorDTO.ArticlesDTO.CitedByDTO mapCitedBy(Map<String, Object> citedBy) {
        if(citedBy == null) return null;

        return new AuthorDTO.ArticlesDTO.CitedByDTO(
            (int) citedBy.get("value"),
            (String) citedBy.get("link")
        );
    }
}
