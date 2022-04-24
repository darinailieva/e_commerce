package com.brainstars.ecommerce.models.dtos;

import com.brainstars.ecommerce.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * DTO for products.
 */

@Getter
@Setter
public class ProductsResponse {
    private List<Product> products;
    private int totalRecords;
}
