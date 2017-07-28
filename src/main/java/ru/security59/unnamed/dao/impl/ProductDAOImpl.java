package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.ProductDAO;
import ru.security59.unnamed.entities.Product;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class ProductDAOImpl extends AbstractEntityDAOImpl<Product> implements ProductDAO {

    public ProductDAOImpl(EntityManager entityManager) {
        super(Product.class, entityManager);
    }

}
