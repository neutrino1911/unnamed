package ru.security59.unnamed.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Product;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/product")
public class ProductController extends AbstractController<Product> {

    public ProductController(AbstractEntityService<Product> entityService) {
        super(entityService);
    }

}
