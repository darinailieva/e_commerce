package com.brainstars.ecommerce.controllers;

import com.brainstars.ecommerce.exceptions.EntityNotFoundException;
import com.brainstars.ecommerce.exceptions.InvalidParameterException;
import com.brainstars.ecommerce.models.dtos.CategoryCreateRequest;
import com.brainstars.ecommerce.models.dtos.CategoryCreateResponse;
import com.brainstars.ecommerce.models.dtos.CategoryResponse;
import com.brainstars.ecommerce.services.CategoryService;
import com.brainstars.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

import static com.brainstars.ecommerce.mappers.CategoryMapper.convertFromCategoryCreateRequest;
import static com.brainstars.ecommerce.mappers.CategoryMapper.convertToCategoryResponse;

/**
 * Rest controller for creating category, adding products to category and getting categories and available products.
 */

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping
    public List<CategoryResponse> getCategories() {
        return convertToCategoryResponse(categoryService.getAll());
    }

    @PostMapping
    public CategoryCreateResponse createCategory(@RequestBody CategoryCreateRequest request) {
        validateCategoryCreateRequest(request);
        var category = convertFromCategoryCreateRequest(request);
        return new CategoryCreateResponse(categoryService.createCategory(category));
    }

    @PatchMapping("/{categoryId}/add/{productId}")
    public String addProductToCategory(@PathVariable int categoryId, @PathVariable int productId) {
        var category = categoryService.getById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category", categoryId));

        var product = productService.getById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product", productId));

        categoryService.addProductToCategory(category, product);
        return String.format("You have successfully added product %s to %s category.", product.getName(), category.getCategory());
    }

    private void validateCategoryCreateRequest(CategoryCreateRequest request) {
        if (Objects.isNull(request.getCategory())) {
            throw new InvalidParameterException("Category");
        }
    }
}
