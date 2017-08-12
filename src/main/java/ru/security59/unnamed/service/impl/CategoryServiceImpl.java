package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.CategoryDAO;
import ru.security59.unnamed.entities.Category;
import ru.security59.unnamed.service.CategoryService;

@Service
public class CategoryServiceImpl extends AbstractEntityServiceImpl<Category> implements CategoryService {

    public CategoryServiceImpl(CategoryDAO entityDAO) {
        super(entityDAO);
    }

}
