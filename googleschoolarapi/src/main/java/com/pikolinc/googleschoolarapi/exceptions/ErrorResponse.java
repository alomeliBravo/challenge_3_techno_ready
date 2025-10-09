package com.pikolinc.googleschoolarapi.exceptions;

public record ErrorResponse(
        int status,
        String errorMessage
) {}
