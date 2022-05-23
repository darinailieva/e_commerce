package com.brainstars.ecommerce.services.impls;

import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.models.dtos.CategoryResponse;
import com.brainstars.ecommerce.repository.ProductRepository;
import com.brainstars.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Implementation class for Products.
 */

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll(PageRequest pageRequest) {
        String[] requests = pageRequest.getSort().toString().split(": ");
        if (requests[1].equals("DESC")) {
            switch (requests[0]) {
                case "name":
                    return productRepository.getAllByOrderByNameDesc(pageRequest);
                case "quantity":
                    return productRepository.getAllByQuantityDesc(pageRequest);
                case "createdDate":
                    return productRepository.getAllByCreatedDateDesc(pageRequest);
                case "lastModifiedDate":
                    return productRepository.getAllByLastModifiedDateDesc(pageRequest);
                default:
                    return  productRepository.getAllByIdDesc(pageRequest);
            }
        } else {
            switch (requests[0]) {
                case "name":
                    return productRepository.getAllByOrderByNameAsc(pageRequest);
                case "quantity":
                    return productRepository.getAllByQuantityAsc(pageRequest);
                case "createdDate":
                    return productRepository.getAllByCreatedDateAsc(pageRequest);
                case "lastModifiedDate":
                    return  productRepository.getAllByLastModifiedDateAsc(pageRequest);
                default:
                    return productRepository.getAllByIdAsc(pageRequest);
            }
        }
    }

    @Override
    public Optional<Product> getById(int id) {
        return productRepository.findById(id);
    }


    @Override
    public List<CategoryResponse> getCategories() {
        return null;
    }

    @Override
    @Transactional
    public int createProduct(Product product) {
        productRepository.save(product);
        return product.getId();
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product, int quantity) {
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

}
