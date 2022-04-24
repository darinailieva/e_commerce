package com.brainstars.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception when the submitted data is invalid.
 */

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String attribute) {
        super(String.format("%s cannot be null or less than zero.", attribute));
    }
}
