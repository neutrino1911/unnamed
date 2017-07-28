package ru.security59.unnamed.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Image;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/image")
public class ImageController extends AbstractController<Image> {

    public ImageController(AbstractEntityService<Image> entityService) {
        super(entityService);
    }

}
