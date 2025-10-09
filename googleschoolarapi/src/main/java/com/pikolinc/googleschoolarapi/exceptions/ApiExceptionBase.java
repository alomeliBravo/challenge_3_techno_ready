package com.pikolinc.googleschoolarapi.exceptions;

import org.springframework.http.HttpStatus;

public abstract class ApiExceptionBase extends RuntimeException {

    public ApiExceptionBase(String errorMessage) {
        super(errorMessage);
    }

    public abstract HttpStatus getHttpStatus();

}
