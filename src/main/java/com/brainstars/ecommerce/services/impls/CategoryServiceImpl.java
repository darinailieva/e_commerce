package com.brainstars.ecommerce.services.impls;

import com.brainstars.ecommerce.models.Category;
import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.repository.CategoryRepository;
import com.brainstars.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation class for Categories.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getById(int categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public int createCategory(Category category) {
        categoryRepository.save(category);
        return category.getCategoryId();
    }

    @Override
    public void addProductToCategory(Category category, Product product) {
        category.addProduct(product);
        categoryRepository.save(category);
    }
}
