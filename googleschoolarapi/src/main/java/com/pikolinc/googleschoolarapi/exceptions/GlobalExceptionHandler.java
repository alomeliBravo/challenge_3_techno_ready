package com.pikolinc.googleschoolarapi.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ApiExceptionBase.class)
    public ResponseEntity<ErrorResponse> handleApiException(ApiExceptionBase ex){
        ErrorResponse response  = new ErrorResponse(
                ex.getHttpStatus().value(),
                ex.getMessage()
        );
        return ResponseEntity.status(ex.getHttpStatus()).body(response);
    }
}
