package com.brainstars.ecommerce.repository;

import com.brainstars.ecommerce.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * JPA repository for Products.
 */

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("FROM Product p where p.name like %:name% ORDER BY p.name")
    List<Product> findAllByOrderByName(String name, Pageable pageable);

    @Query("select p.category, count(p.category) From Product p group By p.category")
    List<Object[]> findAllByCategories();

}

