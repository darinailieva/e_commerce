package com.brainstars.ecommerce.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception when the submitted quantity is insufficient.
 */

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InsufficientQuantityException extends RuntimeException {
    public InsufficientQuantityException(int quantity, int currentQuantity) {
        super(String.format("Insufficient quantity: %d. Current quantity: %d. Please make a new order.", quantity, currentQuantity));
    }
}

