package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.CategoryDAO;
import ru.security59.unnamed.entities.Category;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CategoryDAOImpl extends AbstractEntityDAOImpl<Category> implements CategoryDAO {

    public CategoryDAOImpl(EntityManager entityManager) {
        super(Category.class, entityManager);
    }

}
