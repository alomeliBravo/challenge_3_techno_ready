package com.pikolinc.googleschoolarapi.services;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;
import com.pikolinc.googleschoolarapi.exceptions.author.AuthorMissingPropertyException;
import com.pikolinc.googleschoolarapi.exceptions.author.AuthorNotFoundException;
import com.pikolinc.googleschoolarapi.mappers.AuthorDTOMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

/**
 * Service for interacting with the Google Scholar API through SerpAPI.
 * <p>
 * Handles author lookups and response mapping to {@link AuthorDTO}.
 * </p>
 */
@Service
public class GoogleScholarService {
    private final RestTemplate restTemplate;

    @Value("${serp.api.base.url}")
    private String baseUrl;

    @Value("${serp.api.key}")
    private String apiKey;

    /**
     * Injects {@link RestTemplate} dependency.
     *
     * @param restTemplate HTTP client for API requests
     */
    public GoogleScholarService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    /**
     * Fetches author information from Google Scholar using SerpAPI.
     *
     * @param authorId unique author ID from Google Scholar
     * @return mapped {@link AuthorDTO} object
     * @throws AuthorMissingPropertyException if API key is missing
     * @throws AuthorNotFoundException if author is not found
     */
    public AuthorDTO getAuthorById(String authorId){
        if(this.apiKey == null || this.apiKey.isEmpty()){
            throw new AuthorMissingPropertyException("API Key is missing");
        }

        String url = UriComponentsBuilder.fromUriString(baseUrl)
                .queryParam("engine","google_scholar_author")
                .queryParam("author_id", authorId)
                .queryParam("api_key",this.apiKey)
                .toUriString();

        ResponseEntity<Map<String, Object>> response  = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Map<String, Object>>(){}
        );

        Map<String, Object> apiResponse = response.getBody();

        if(apiResponse == null || !apiResponse.containsKey("author")){
            throw new AuthorNotFoundException("Author with ID " +  authorId + " not found");
        }

        return AuthorDTOMapper.mapToAuthorDTO(apiResponse, authorId);
    }
}
