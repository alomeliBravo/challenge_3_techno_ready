package com.pikolinc.googleschoolarapi.controllers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;
import com.pikolinc.googleschoolarapi.exceptions.author.AuthorMissingPropertyException;
import com.pikolinc.googleschoolarapi.services.GoogleScholarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * REST controller for managing author-related endpoints.
 * <p>
 * Provides endpoints to fetch author information from Google Scholar via {@link GoogleScholarService}.
 * </p>
 */
@RestController
@RequestMapping("/author")
class AuthorController {
    private final GoogleScholarService googleScholarService;

    /**
     * Injects {@link GoogleScholarService}.
     *
     * @param googleScholarService service layer for author operations
     */
    AuthorController(GoogleScholarService googleScholarService) {
        this.googleScholarService = googleScholarService;
    }

    /**
     * Retrieves author information by ID.
     *
     * @param id author's unique ID
     * @return {@link AuthorDTO} containing author data
     */
    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@PathVariable String id) {
        return googleScholarService.getAuthorById(id);
    }

    /**
     * Throws an exception if the endpoint is called without an author ID.
     *
     * @throws AuthorMissingPropertyException always
     */
    @GetMapping("/")
    public AuthorDTO getAuthorWithoutId(){
        throw new AuthorMissingPropertyException("Author ID is required in the path: use /author/{id}");
    }
}
