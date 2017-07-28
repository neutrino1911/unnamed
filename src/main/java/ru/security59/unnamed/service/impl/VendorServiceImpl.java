package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.AbstractEntityDAO;
import ru.security59.unnamed.entities.Vendor;
import ru.security59.unnamed.service.VendorService;

@Service
public class VendorServiceImpl extends AbstractEntityServiceImpl<Vendor> implements VendorService {

    public VendorServiceImpl(AbstractEntityDAO<Vendor> entityDAO) {
        super(entityDAO);
    }

}
