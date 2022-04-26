package com.brainstars.ecommerce.services.impls;

import com.brainstars.ecommerce.exceptions.EntityNotFoundException;
import com.brainstars.ecommerce.exceptions.InsufficientQuantityException;
import com.brainstars.ecommerce.exceptions.InvalidParameterException;
import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.repository.ProductRepository;
import com.brainstars.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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
    public List<Product> getAll(String orderBy, Sort.Direction direction, Pageable pageable) {
        if (direction == Sort.Direction.DESC) {
            switch (orderBy) {
                case "name":
                    return productRepository.findAllOrderByNameDESC(orderBy, pageable);
                case "quantity":
                    return productRepository.findAllOrderByQuantityDESC(orderBy, pageable);
                case "createdDate":
                    return productRepository.findAllOrderByCreatedDateDESC(orderBy, pageable);
                case "lastModifiedDate":
                    return productRepository.findAllOrderByLastModifiedDateDESC(orderBy, pageable);
                default:
                    return productRepository.getAllDESC();

            }
        } else {
            switch (orderBy) {
                case "name":
                    return productRepository.findAllOrderByNameASC(orderBy, pageable);
                case "quantity":
                    return productRepository.findAllOrderByQuantityASC(orderBy, pageable);
                case "createdDate":
                    return productRepository.findAllOrderByCreatedDateASC(orderBy, pageable);
                case "lastModifiedDate":
                    return productRepository.findAllOrderByLastModifiedDateASC(orderBy, pageable);
                default:
                    return productRepository.getAllASC();
            }
        }
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product", id));
    }

    @Override
    public List<Object[]> getAllByCategories() {
        return productRepository.findAllByCategories();
    }

    @Override
    @Transactional
    public int createProduct(Product product) {
        validateProduct(product);
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
        validateSufficientQuantity(product, quantity);
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    private void validateProduct(Product product) {
        if (Objects.isNull(product)) {
            throw new InvalidParameterException("Product");
        }
        if (Objects.isNull(product.getName())) {
            throw new InvalidParameterException("Name");
        }
        if (Objects.isNull(product.getCategory())) {
            throw new InvalidParameterException("Category");
        }
        if (product.getQuantity() < 0) {
            throw new InvalidParameterException("Quantity");
        }
    }

    private void validateSufficientQuantity(Product product, int quantity) {
        if (quantity >= product.getQuantity()) {
            throw new InsufficientQuantityException(quantity, product.getQuantity());
        }
    }
}
