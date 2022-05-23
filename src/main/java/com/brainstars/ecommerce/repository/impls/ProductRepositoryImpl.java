package com.brainstars.ecommerce.repository.impls;

import com.brainstars.ecommerce.models.Product;
import com.brainstars.ecommerce.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Product repository implementation.
 */
public class ProductRepositoryImpl extends BaseRepositoryImpl<Product, Integer> implements ProductRepository {
    public ProductRepositoryImpl(EntityManager em) {
        super(Product.class, em);
    }

    @Override
    public List<Product> getAllByOrderByNameAsc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.name.asc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> getAllByQuantityAsc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.quantity.asc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> getAllByCreatedDateAsc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.createdDate.asc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> getAllByLastModifiedDateAsc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.lastModifiedDate.asc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> getAllByIdAsc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.id.asc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> getAllByOrderByNameDesc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.name.desc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> getAllByQuantityDesc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.quantity.desc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> getAllByCreatedDateDesc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.createdDate.desc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

    @Override
    public List<Product> getAllByLastModifiedDateDesc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.lastModifiedDate.desc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }
    @Override
    public List<Product> getAllByIdDesc(PageRequest pageRequest) {
        return factory.selectFrom(product)
                .orderBy(product.id.desc())
                .limit(pageRequest.getPageSize())
                .fetch();
    }

}
