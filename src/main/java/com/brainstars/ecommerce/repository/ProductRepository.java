package com.brainstars.ecommerce.repository;

import com.brainstars.ecommerce.models.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * JPA repository for Products.
 */

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    List<Product> getAllByOrderByNameDesc(PageRequest pageRequest);
    List<Product> getAllByQuantityDesc(PageRequest pageRequest);
    List<Product> getAllByCreatedDateDesc(PageRequest pageRequest);
    List<Product>getAllByLastModifiedDateDesc(PageRequest pageRequest);
    List<Product> getAllByIdDesc(PageRequest pageRequest);
    List<Product> getAllByOrderByNameAsc(PageRequest pageRequest);
    List<Product> getAllByQuantityAsc(PageRequest pageRequest);
    List<Product> getAllByCreatedDateAsc(PageRequest pageRequest);
    List<Product> getAllByLastModifiedDateAsc(PageRequest pageRequest);
    List<Product> getAllByIdAsc(PageRequest pageRequest);
}

