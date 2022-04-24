package com.brainstars.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.function.Supplier;

/**
 * Custom exception when searching for non-existing entry.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String type, long attribute) {
        super(String.format("%s with id %s does not exist.",type, attribute));
    }
}