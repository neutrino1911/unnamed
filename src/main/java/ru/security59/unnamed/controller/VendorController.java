package ru.security59.unnamed.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Vendor;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/vendor")
public class VendorController extends AbstractController<Vendor> {

    public VendorController(AbstractEntityService<Vendor> entityService) {
        super(entityService);
    }

}
