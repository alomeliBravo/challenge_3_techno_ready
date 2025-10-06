package com.pikolinc.googleschoolarapi.mappers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InterestDTOMapper {
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
