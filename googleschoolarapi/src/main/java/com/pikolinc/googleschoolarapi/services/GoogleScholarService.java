package com.pikolinc.googleschoolarapi.services;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;
import com.pikolinc.googleschoolarapi.mappers.AuthorDTOMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class GoogleScholarService {
    private final RestTemplate restTemplate;

    @Value("${serp.api.base.url}")
    private String baseUrl;

    @Value("${serp.api.key}")
    private String apiKey;

    public GoogleScholarService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    public AuthorDTO getAuthorById(String authorId){
        String url = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("engine","google_scholar_author")
                .queryParam("author_id", authorId)
                .queryParam("api_key",this.apiKey)
                .toUriString();

        Map<String, Object> apiResponse = restTemplate.getForObject(url, Map.class);

        if(apiResponse == null || !apiResponse.containsKey("author")){
            return null;
        }

        return AuthorDTOMapper.mapToAuthorDTO(apiResponse, authorId);
    }
}
