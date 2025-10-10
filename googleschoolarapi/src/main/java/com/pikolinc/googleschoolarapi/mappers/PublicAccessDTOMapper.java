package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.Map;

/**
 * Mapper for converting public access data from API responses into {@link AuthorDTO.PublicAccessDTO}.
 */
public class PublicAccessDTOMapper {
    /**
     * Maps public access information from a data map to {@link AuthorDTO.PublicAccessDTO}.
     *
     * @param publicAccess map containing public access details
     * @return mapped {@link AuthorDTO.PublicAccessDTO}, or {@code null} if input is null
     */
    public static AuthorDTO.PublicAccessDTO mapPublicAccess(Map<String,Object> publicAccess) {
        if(publicAccess == null) return null;

        return new AuthorDTO.PublicAccessDTO(
                (String) publicAccess.get("link"),
                (int) publicAccess.get("available"),
                (int) publicAccess.get("not_available")
        );
    }
}
