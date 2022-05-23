package com.brainstars.ecommerce.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Category entity.
 */
@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category")
    String category;

    @OneToMany(mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Product> products;

    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }
}
