package com.brainstars.ecommerce.services.impls;

import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.repository.ProductRepository;
import com.brainstars.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public Optional<Product> getById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Object[]> getAllByCategories() {
        return productRepository.findAllByCategories();
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
