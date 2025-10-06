package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.Map;

public class PublicAccessDTOMapper {
    public static AuthorDTO.PublicAccessDTO mapPublicAccess(Map<String,Object> publicAccess) {
        if(publicAccess == null) return null;

        return new AuthorDTO.PublicAccessDTO(
                (String) publicAccess.get("link"),
                (int) publicAccess.get("available"),
                (int) publicAccess.get("not_available")
        );
    }
}
