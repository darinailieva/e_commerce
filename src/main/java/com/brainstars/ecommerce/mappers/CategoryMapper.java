package com.brainstars.ecommerce.mappers;

import com.brainstars.ecommerce.models.Category;
import com.brainstars.ecommerce.models.dtos.CategoryCreateRequest;
import com.brainstars.ecommerce.models.dtos.CategoryResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Helper class for mapping dto to its model and vice versa.
 */
public class CategoryMapper {
    public static Category convertFromCategoryCreateRequest(CategoryCreateRequest request) {
        var category = new Category();
        if (Objects.nonNull(request)) {
            category.setCategory(request.getCategory());
        }
        return category;
    }
    public static List<CategoryResponse> convertToCategoryResponse(List<Category> categories) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Category category : categories) {
            var categoryResponse = new CategoryResponse();
            categoryResponse.setCategory(category.getCategory());
            categoryResponse.setProductsAvailable(category.getProducts().size());
            categoryResponses.add(categoryResponse);
        }
        return categoryResponses;
    }
}
