package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Vendor;
import ru.security59.unnamed.service.VendorService;

@RestController
@RequestMapping(path = "/api/vendors")
public class VendorController extends AbstractEntityController<Vendor> {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        super(vendorService);
        this.vendorService = vendorService;
    }

}
