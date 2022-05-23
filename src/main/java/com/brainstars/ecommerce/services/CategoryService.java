package com.brainstars.ecommerce.services;

import com.brainstars.ecommerce.models.Category;
import com.brainstars.ecommerce.models.Product;

import java.util.List;
import java.util.Optional;

/**
 * Interface for categories.
 */
public interface CategoryService {
    List<Category> getAll();
    int createCategory(Category category);
    Optional<Category> getById(int categoryId);
    void addProductToCategory(Category category, Product product);


}
