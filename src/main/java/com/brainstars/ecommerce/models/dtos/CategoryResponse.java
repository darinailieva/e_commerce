package com.brainstars.ecommerce.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
