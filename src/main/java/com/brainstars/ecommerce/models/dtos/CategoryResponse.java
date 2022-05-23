package com.brainstars.ecommerce.models.dtos;

import lombok.*;

/**
 * DTO for categories.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponse {
    private String category;
    private int productsAvailable;
}
