package com.pikolinc.googleschoolarapi.services;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;
import com.pikolinc.googleschoolarapi.entity.ArticleEntity;
import com.pikolinc.googleschoolarapi.exceptions.author.AuthorMissingPropertyException;
import com.pikolinc.googleschoolarapi.exceptions.author.AuthorNotFoundException;
import com.pikolinc.googleschoolarapi.mappers.ArticleEntityMapper;
import com.pikolinc.googleschoolarapi.mappers.AuthorDTOMapper;
import com.pikolinc.googleschoolarapi.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@Service
public class ArticleService {

    private final RestTemplate restTemplate;
    private final ArticleRepository articleRepository;

    @Value("${serp.api.base.url}")
    private String baseUrl;

    @Value("${serp.api.key}")
    private String apiKey;

    ArticleService(RestTemplate restTemplate, ArticleRepository articleRepository){
        this.restTemplate = restTemplate;
        this.articleRepository = articleRepository;
    }

    public ArticleEntity saveArticle(String authorId, int position){

        if(authorId == null || authorId.isEmpty()){
            throw new AuthorMissingPropertyException("authorId cannot be empty");
        }
        if(this.apiKey == null || this.apiKey.isEmpty()){
            throw new AuthorMissingPropertyException("apiKey cannot be empty");
        }
        if(position< 0){
            throw new RuntimeException("articlePosition cannot be negative");
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

        AuthorDTO authorDTO = AuthorDTOMapper.mapToAuthorDTO(apiResponse, authorId);

        ArticleEntity articleEntity = ArticleEntityMapper.mapFromAuthorDTO(authorDTO, position);

        return articleRepository.save(articleEntity);

    }

    public List<ArticleEntity> getAllArticles(){
        return articleRepository.findAll();
    }

    public List<ArticleEntity> getArticlesByTitle(String title){
        if (title == null || title.isEmpty()){
            throw new RuntimeException("title cannot be empty");
        }

        return articleRepository.findByTitle(title);
    }

    public List<ArticleEntity> getArticlesByAuthor(String author){
        if(author == null || author.isEmpty()){
            throw new RuntimeException("author cannot be empty");
        }

        return articleRepository.findByAuthorsContaining(author);
    }

    public ArticleEntity getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    public void deleteArticleById(Long id) {
        if (id == null) {
            throw new RuntimeException("articleId cannot be null");
        }
        articleRepository.deleteById(id);
    }
}
