package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.AbstractEntityDAO;
import ru.security59.unnamed.entities.Product;
import ru.security59.unnamed.service.ProductService;

@Service
public class ProductServiceImpl extends AbstractEntityServiceImpl<Product> implements ProductService {

    public ProductServiceImpl(AbstractEntityDAO<Product> entityDAO) {
        super(entityDAO);
    }

}
