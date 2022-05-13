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
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

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
    public ProductsResponse getProducts(@RequestParam String orderBy,
                                        @RequestParam Sort.Direction direction,
                                        @RequestParam int page,
                                        @RequestParam int size) {
        return convertToProductsResponse(productService.getAll(orderBy, direction, PageRequest.of(page, size)));
    }

    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductCreateRequest request) {
        validateProductCreateRequest(request);
        var product = convertToProductFromCreateRequest(request);
        return new ProductResponse(productService.createProduct(product));

    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(@PathVariable int id, @RequestBody ProductUpdateRequest request) {
        var product = productService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product", id));

        product = convertToProductFromUpdateRequest(request, product);
        productService.updateProduct(product);
        return new ProductResponse(id);
    }

    @DeleteMapping("/{id}")
    public ProductResponse deleteProduct(@PathVariable int id) {
        var product = productService.getById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product", id));

        productService.deleteProduct(product);
        return new ProductResponse(id);
    }

    private void validateProductCreateRequest(ProductCreateRequest request) {
        if (Objects.isNull(request.getName())) {
            throw new InvalidParameterException("Name");
        }
        if (Objects.isNull(request.getCategory())) {
            throw new InvalidParameterException("Category");
        }
        if (request.getQuantity() < 0) {
            throw new InvalidParameterException("Quantity");
        }
    }
}
