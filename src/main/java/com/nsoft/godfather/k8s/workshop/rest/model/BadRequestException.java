package com.nsoft.godfather.k8s.workshop.rest.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BadRequestException
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private static final long serialVersionUID = 7868189347665914373L;

    public BadRequestException(String message) {
        super(message);
    }
}
