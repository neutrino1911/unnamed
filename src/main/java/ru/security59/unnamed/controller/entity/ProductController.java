package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Product;
import ru.security59.unnamed.service.ProductService;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController extends AbstractEntityController<Product> {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        super(productService);
        this.productService = productService;
    }

}
