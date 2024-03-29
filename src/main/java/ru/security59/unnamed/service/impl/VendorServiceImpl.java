package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.VendorDAO;
import ru.security59.unnamed.entities.Vendor;
import ru.security59.unnamed.service.VendorService;

@Service
public class VendorServiceImpl extends AbstractEntityServiceImpl<Vendor> implements VendorService {

    private final VendorDAO vendorDAO;

    public VendorServiceImpl(VendorDAO vendorDAO) {
        super(vendorDAO);
        this.vendorDAO = vendorDAO;
    }

}
