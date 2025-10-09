package com.pikolinc.googleschoolarapi.exceptions.author;

import com.pikolinc.googleschoolarapi.exceptions.ApiExceptionBase;
import org.springframework.http.HttpStatus;

public class AuthorNotFoundException extends ApiExceptionBase {

    public AuthorNotFoundException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
