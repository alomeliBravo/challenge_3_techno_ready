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

/**
 * Service class responsible for handling all article-related operations.
 * <p>
 * This service interacts with the SerpAPI (Google Scholar API) to fetch author and article
 * information, maps the data into {@link ArticleEntity}, and persists it into the database
 * using {@link ArticleRepository}.
 * </p>
 *
 * @author
 * @version 1.0
 */
@Service
public class ArticleService {

    private final RestTemplate restTemplate;
    private final ArticleRepository articleRepository;

    /**
     * Base URL for the SerpAPI service, injected from application properties.
     */
    @Value("${serp.api.base.url}")
    private String baseUrl;

    /**
     * API key for authenticating requests to SerpAPI.
     */
    @Value("${serp.api.key}")
    private String apiKey;

    /**
     * Constructs an {@code ArticleService} with the required dependencies.
     *
     * @param restTemplate       the HTTP client used to send requests to SerpAPI
     * @param articleRepository  the repository interface used for database operations
     */
    ArticleService(RestTemplate restTemplate, ArticleRepository articleRepository){
        this.restTemplate = restTemplate;
        this.articleRepository = articleRepository;
    }

    /**
     * Fetches an author's information and their articles from the SerpAPI,
     * maps the result to an {@link ArticleEntity}, and saves it in the database.
     *
     * @param authorId the ID of the author to fetch data for
     * @param position the article's position in the author's publication list
     * @return the saved {@link ArticleEntity} object
     * @throws AuthorMissingPropertyException if {@code authorId} or {@code apiKey} is missing
     * @throws AuthorNotFoundException        if the author does not exist in SerpAPI
     * @throws RuntimeException               if {@code position} is negative
     */
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

    /**
     * Retrieves all articles stored in the database.
     *
     * @return a list of all {@link ArticleEntity} records
     */
    public List<ArticleEntity> getAllArticles(){
        return articleRepository.findAll();
    }

    /**
     * Retrieves all articles with a matching title.
     *
     * @param title the title to search for
     * @return a list of matching {@link ArticleEntity} records
     * @throws RuntimeException if {@code title} is null or empty
     */
    public List<ArticleEntity> getArticlesByTitle(String title){
        if (title == null || title.isEmpty()){
            throw new RuntimeException("title cannot be empty");
        }

        return articleRepository.findByTitle(title);
    }

    /**
     * Retrieves all articles written by a specific author.
     *
     * @param author the author name to search for
     * @return a list of {@link ArticleEntity} records containing the given author
     * @throws RuntimeException if {@code author} is null or empty
     */
    public List<ArticleEntity> getArticlesByAuthor(String author){
        if(author == null || author.isEmpty()){
            throw new RuntimeException("author cannot be empty");
        }

        return articleRepository.findByAuthorsContaining(author);
    }

    /**
     * Retrieves an article by its database ID.
     *
     * @param id the unique identifier of the article
     * @return the {@link ArticleEntity} corresponding to the ID
     * @throws RuntimeException if no article with the given ID exists
     */
    public ArticleEntity getArticleById(Long id) {
        return articleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    /**
     * Deletes an article from the database by its ID.
     *
     * @param id the unique identifier of the article to delete
     * @throws RuntimeException if {@code id} is null
     */
    public void deleteArticleById(Long id) {
        if (id == null) {
            throw new RuntimeException("articleId cannot be null");
        }
        articleRepository.deleteById(id);
    }
}
