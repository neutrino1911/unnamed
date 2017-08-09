package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Vendor;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/vendors")
public class VendorController extends AbstractEntityController<Vendor> {

    public VendorController(AbstractEntityService<Vendor> entityService) {
        super(entityService);
    }

}
