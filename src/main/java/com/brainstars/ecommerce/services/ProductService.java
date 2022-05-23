package com.brainstars.ecommerce.services;

import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.models.dtos.CategoryResponse;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * Interface for products.
 */

public interface ProductService {
    List<Product> getAll(PageRequest pageRequest);

    int createProduct(Product product);

    Optional<Product> getById(int id);

    void updateProduct(Product product);

    void updateProduct(Product product, int quantity);

    void deleteProduct(Product product);

   // List<Object[]> getAllByCategories();
    List<CategoryResponse> getCategories();

  //  List<Product> getProductsByNameContainingIgnoreCaseOrderByNameDesc(String name);
}
