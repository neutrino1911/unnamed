package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Category;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/category")
public class CategoryController extends AbstractEntityController<Category> {

    public CategoryController(AbstractEntityService<Category> entityService) {
        super(entityService);
    }

}
