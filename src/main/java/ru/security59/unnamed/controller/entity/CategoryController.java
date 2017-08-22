package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Category;
import ru.security59.unnamed.service.CategoryService;

@RestController
@RequestMapping(path = "/api/categories")
public class CategoryController extends AbstractEntityController<Category> {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super(categoryService);
        this.categoryService = categoryService;
    }

}
