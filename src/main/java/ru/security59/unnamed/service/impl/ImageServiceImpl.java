package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.AbstractEntityDAO;
import ru.security59.unnamed.entities.Image;
import ru.security59.unnamed.service.ImageService;

@Service
public class ImageServiceImpl extends AbstractEntityServiceImpl<Image> implements ImageService {

    public ImageServiceImpl(AbstractEntityDAO<Image> entityDAO) {
        super(entityDAO);
    }

}
