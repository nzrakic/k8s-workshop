package com.nsoft.godfather.k8s.workshop.rest.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * TodoFoundException
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TodoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2408525538545761647L;

    public TodoNotFoundException(int id) {
        super(String.format("Todo with id '%s' not found", id));
    }
}