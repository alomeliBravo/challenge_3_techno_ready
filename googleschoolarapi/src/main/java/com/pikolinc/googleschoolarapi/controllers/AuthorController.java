package com.pikolinc.googleschoolarapi.controllers;

import com.pikolinc.googleschoolarapi.dto.AuthorDTO;
import com.pikolinc.googleschoolarapi.exceptions.author.AuthorMissingPropertyException;
import com.pikolinc.googleschoolarapi.services.GoogleScholarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/author")
class AuthorController {
    private final GoogleScholarService googleScholarService;

    AuthorController(GoogleScholarService googleScholarService) {
        this.googleScholarService = googleScholarService;
    }

    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@PathVariable String id) {
        return googleScholarService.getAuthorById(id);
    }

    @GetMapping("/")
    public AuthorDTO getAuthorWithoutId(){
        throw new AuthorMissingPropertyException("Author ID is required in the path: use /author/{id}");
    }
}
