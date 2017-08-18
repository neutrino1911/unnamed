package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Image;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/api/images")
public class ImageController extends AbstractEntityController<Image> {

    public ImageController(AbstractEntityService<Image> entityService) {
        super(entityService);
    }

}
