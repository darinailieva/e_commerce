package com.brainstars.ecommerce.controllers;

import com.brainstars.ecommerce.exceptions.InsufficientQuantityException;
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
        var product = productService.getById(productId);
        try {
            productService.updateProduct(product, quantity);
        } catch (InsufficientQuantityException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
        return String.format("You have successfully ordered %d %s.", quantity, product.getName());
    }
}
