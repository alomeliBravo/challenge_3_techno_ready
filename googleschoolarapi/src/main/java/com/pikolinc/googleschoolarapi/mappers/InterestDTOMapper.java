package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Mapper for converting interest data from API responses into {@link AuthorDTO.InterestDTO} objects.
 */
public class InterestDTOMapper {
    /**
     * Maps a list of interest data maps to a list of {@link AuthorDTO.InterestDTO}.
     *
     * @param interests list of maps representing interest data
     * @return list of mapped {@link AuthorDTO.InterestDTO}, or an empty list if input is null
     */
    public static List<AuthorDTO.InterestDTO> mapInterest(List<Map<String, Object>> interests){
        if(interests == null) return List.of();

        return interests.stream()
            .map(interest -> new AuthorDTO.InterestDTO(
                    (String) interest.get("title"),
                    (String) interest.get("link")
            ))
            .collect(Collectors.toList());
    }
}
