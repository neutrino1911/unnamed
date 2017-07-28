package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.ImageDAO;
import ru.security59.unnamed.entities.Image;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class ImageDAOImpl extends AbstractEntityDAOImpl<Image> implements ImageDAO {

    public ImageDAOImpl(EntityManager entityManager) {
        super(Image.class, entityManager);
    }

}
