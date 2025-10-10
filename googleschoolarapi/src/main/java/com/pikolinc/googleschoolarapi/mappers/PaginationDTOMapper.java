package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.Map;

/**
 * Mapper for converting pagination data from API responses into {@link AuthorDTO.PaginationDTO}.
 */
public class PaginationDTOMapper {
    /**
     * Maps pagination information from a data map to {@link AuthorDTO.PaginationDTO}.
     *
     * @param pagination map containing pagination info
     * @return mapped {@link AuthorDTO.PaginationDTO}, or {@code null} if input is null
     */
    public static AuthorDTO.PaginationDTO mapPagination(Map<String, Object> pagination) {
        if(pagination == null) return null;

        return new AuthorDTO.PaginationDTO(
            (String) pagination.get("next")
        );
    }
}
