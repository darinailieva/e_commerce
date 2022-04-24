package com.brainstars.ecommerce.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO for updating a product.
 */

@Getter
@Setter
@AllArgsConstructor
public class ProductUpdateRequest {
    private String name;
    private String category;
    private String description;
}
