package com.brainstars.ecommerce.repository.impls;

import com.brainstars.ecommerce.models.QProduct;
import com.brainstars.ecommerce.models.QCategory;
import com.brainstars.ecommerce.repository.BaseRepository;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

/**
 * Base repository implementation.
 */
public abstract class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
    protected EntityManager em;
    protected final JPAQuery<T> query;
    protected final JPAQueryFactory factory;

    protected final QProduct product = QProduct.product;
    protected final QCategory category = QCategory.category1;

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        this.em = em;
        this.query = new JPAQuery<>(em);
        this.factory = new JPAQueryFactory(em);
    }
}
