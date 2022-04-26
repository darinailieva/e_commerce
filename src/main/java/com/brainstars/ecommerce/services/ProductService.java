package com.brainstars.ecommerce.services;

import com.brainstars.ecommerce.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Interface for products.
 */

public interface ProductService {
    List<Product> getAll(String orderBy, Sort.Direction direction, Pageable pageable);

    int createProduct(Product product);

    Product getById(int id);

    void updateProduct(Product product);

    void updateProduct(Product product, int quantity);

    void deleteProduct(Product product);

    List<Object[]> getAllByCategories();
}
