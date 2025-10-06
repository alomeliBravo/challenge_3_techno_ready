package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.Map;

public class PaginationDTOMapper {
    public static AuthorDTO.PaginationDTO mapPagination(Map<String, Object> pagination) {
        if(pagination == null) return null;

        return new AuthorDTO.PaginationDTO(
            (String) pagination.get("next")
        );
    }
}
