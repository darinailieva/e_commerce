package com.brainstars.ecommerce.controllers;

import com.brainstars.ecommerce.exceptions.EntityNotFoundException;
import com.brainstars.ecommerce.exceptions.InvalidParameterException;
import com.brainstars.ecommerce.models.dtos.ProductCreateRequest;
import com.brainstars.ecommerce.models.dtos.ProductResponse;
import com.brainstars.ecommerce.models.dtos.ProductUpdateRequest;
import com.brainstars.ecommerce.models.dtos.ProductsResponse;
import com.brainstars.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static com.brainstars.ecommerce.mappers.ProductMapper.*;

/**
 * Rest controller for CRUD operations on products.
 */

@RestController
@RequestMapping("/products")

public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ProductsResponse getProducts(@RequestParam String name,
                                        @RequestParam Sort.Direction direction,
                                        @RequestParam int page,
                                        @RequestParam int size) {
        return convertToProductsResponse(productService.getAll(name, PageRequest.of(page, size, direction, "quantity")));
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductCreateRequest request) {
        try {
            var product = convertToProductFromCreateRequest(request);
            return new ProductResponse(productService.createProduct(product));
        } catch (InvalidParameterException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable int id, @RequestBody ProductUpdateRequest request) {
        try {
            var product = productService.getById(id);
            product = convertToProductFromUpdateRequest(request, product);
            productService.updateProduct(product);
            return new ProductResponse(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ProductResponse deleteProduct(@PathVariable int id) {
        try {
            var product = productService.getById(id);
            productService.deleteProduct(product);
            return new ProductResponse(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
