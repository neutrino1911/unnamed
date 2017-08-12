package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.ImageDAO;
import ru.security59.unnamed.entities.Image;
import ru.security59.unnamed.service.ImageService;

@Service
public class ImageServiceImpl extends AbstractEntityServiceImpl<Image> implements ImageService {

    public ImageServiceImpl(ImageDAO entityDAO) {
        super(entityDAO);
    }

}
