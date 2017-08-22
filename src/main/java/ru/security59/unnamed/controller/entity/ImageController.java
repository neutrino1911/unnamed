package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Image;
import ru.security59.unnamed.service.ImageService;

@RestController
@RequestMapping(path = "/api/images")
public class ImageController extends AbstractEntityController<Image> {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        super(imageService);
        this.imageService = imageService;
    }

}
