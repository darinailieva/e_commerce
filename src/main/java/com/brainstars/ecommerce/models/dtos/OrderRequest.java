package com.brainstars.ecommerce.models.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for orders.
 */
@Getter
@Setter
public class OrderRequest {
    private int productId;
    private int quantity;
}
