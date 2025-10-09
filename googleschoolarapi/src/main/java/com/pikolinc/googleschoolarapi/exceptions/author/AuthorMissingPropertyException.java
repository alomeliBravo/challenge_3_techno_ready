package com.pikolinc.googleschoolarapi.exceptions.author;

import com.pikolinc.googleschoolarapi.exceptions.ApiExceptionBase;
import org.springframework.http.HttpStatus;

public class AuthorMissingPropertyException extends ApiExceptionBase {

    public AuthorMissingPropertyException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public HttpStatus getHttpStatus(){
        return HttpStatus.BAD_REQUEST;
    }
}
