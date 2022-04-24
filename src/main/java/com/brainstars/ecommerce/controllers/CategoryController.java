package com.brainstars.ecommerce.controllers;

import com.brainstars.ecommerce.models.dtos.CategoryResponse;
import com.brainstars.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.brainstars.ecommerce.mappers.ProductMapper.convertToCategoryResponse;

/**
 * Rest controller for getting categories and available products.
 */

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final ProductService productService;

    @Autowired
    public CategoryController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<CategoryResponse> getCategories() {
        return convertToCategoryResponse(productService.getAllByCategories());
    }
}
