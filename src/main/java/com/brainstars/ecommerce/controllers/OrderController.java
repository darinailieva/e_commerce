package com.brainstars.ecommerce.controllers;

import com.brainstars.ecommerce.exceptions.EntityNotFoundException;
import com.brainstars.ecommerce.exceptions.InsufficientQuantityException;
import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Rest controller for posting orders.
 */

@RestController
@RequestMapping("/products")
public class OrderController {
    private final ProductService productService;

    @Autowired
    public OrderController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/{productId}/order/{quantity}")
    public String orderProduct(@PathVariable int productId, @PathVariable int quantity) {
        var product = productService.getById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product", productId));
        validateSufficientQuantity(product, quantity);
        productService.updateProduct(product, quantity);
        return String.format("You have successfully ordered %d %s.", quantity, product.getName());
    }

    private void validateSufficientQuantity(Product product, int quantity) {
        if (quantity >= product.getQuantity()) {
            throw new InsufficientQuantityException(quantity, product.getQuantity());
        }
    }
}
