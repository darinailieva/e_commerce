package com.brainstars.ecommerce.mappers;

import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.models.dtos.CategoryResponse;
import com.brainstars.ecommerce.models.dtos.ProductCreateRequest;
import com.brainstars.ecommerce.models.dtos.ProductUpdateRequest;
import com.brainstars.ecommerce.models.dtos.ProductsResponse;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Helper class for mapping dto to its model and vice versa.
 */

public class ProductMapper {
    public static Product convertToProductFromCreateRequest(ProductCreateRequest request) {
        var product = new Product();
        if (Objects.nonNull(request)) {
            product.setName(request.getName());
            product.setCategory(request.getCategory());
            product.setDescription(request.getDescription());
            product.setQuantity(request.getQuantity());
        }
        return product;
    }

    public static Product convertToProductFromUpdateRequest(ProductUpdateRequest request, Product product) {
        if (Objects.nonNull(request.getName())) {
            product.setName(request.getName());
        }
        if (Objects.nonNull(request.getCategory())) {
            product.setCategory(request.getCategory());
        }
        if (Objects.nonNull(request.getDescription())) {
            product.setDescription(request.getDescription());
        }
        return product;
    }

    public static List<CategoryResponse> convertToCategoryResponse(List<Object[]> categories) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for (Object[] category : categories) {
            var categoryResponse = new CategoryResponse();
            categoryResponse.setCategory(String.valueOf(category[0]));
            categoryResponse.setProductsAvailable(Integer.parseInt(category[1].toString()));
            categoryResponses.add(categoryResponse);
        }
        return categoryResponses;
    }

    public static ProductsResponse convertToProductsResponse(List<Product> products) {
        ProductsResponse productsResponse = new ProductsResponse();
        productsResponse.setProducts(products);
        productsResponse.setTotalRecords(products.size());
        return productsResponse;
    }
}
