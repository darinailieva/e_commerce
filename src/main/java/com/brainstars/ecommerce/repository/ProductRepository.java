package com.brainstars.ecommerce.repository;

import com.brainstars.ecommerce.models.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * JPA repository for Products.
 */

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    @Query("FROM Product p ORDER BY p.name ASC")
    List<Product> findAllOrderByNameASC(String name, Pageable pageable);

    @Query("FROM Product p ORDER BY p.name DESC")
    List<Product> findAllOrderByNameDESC(String name, Pageable pageable);

    @Query("FROM Product p ORDER BY p.quantity DESC")
    List<Product> findAllOrderByQuantityDESC(String orderBy, Pageable pageable);

    @Query("FROM Product p ORDER BY p.quantity ASC")
    List<Product> findAllOrderByQuantityASC(String orderBy, Pageable pageable);

    @Query("FROM Product p ORDER BY p.createdDate DESC")
    List<Product> findAllOrderByCreatedDateDESC(String orderBy, Pageable pageable);

    @Query("FROM Product p ORDER BY p.createdDate ASC")
    List<Product> findAllOrderByCreatedDateASC(String orderBy, Pageable pageable);

    @Query("FROM Product p ORDER BY p.lastModifiedDate DESC")
    List<Product> findAllOrderByLastModifiedDateDESC(String orderBy, Pageable pageable);

    @Query("FROM Product p ORDER BY p.lastModifiedDate ASC")
    List<Product> findAllOrderByLastModifiedDateASC(String orderBy, Pageable pageable);

    @Query("FROM Product p ORDER BY p.id DESC")
    List<Product> getAllDESC();

    @Query("FROM Product p ORDER BY p.id ASC")
    List<Product> getAllASC();

    @Query("select p.category, count(p.category) From Product p group By p.category")
    List<Object[]> findAllByCategories();

}

