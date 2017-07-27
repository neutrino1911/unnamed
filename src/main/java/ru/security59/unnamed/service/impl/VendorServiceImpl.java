package ru.security59.unnamed.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.VendorDAO;
import ru.security59.unnamed.entities.Vendor;
import ru.security59.unnamed.service.VendorService;

import java.util.Set;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorDAO vendorDAO;

    @Autowired
    public VendorServiceImpl(VendorDAO vendorDAO) {
        this.vendorDAO = vendorDAO;
    }

    @Override
    public Vendor getVendorById(Integer id) {
        return vendorDAO.getVendorById(id);
    }

    @Override
    public void addVendor(Vendor vendor) {
        vendorDAO.addVendor(vendor);
    }

    @Override
    public Vendor updateVendor(Vendor vendor) {
        return vendorDAO.updateVendor(vendor);
    }

    @Override
    public void deleteVendorById(Integer id) {
        vendorDAO.deleteVendorById(id);
    }

    @Override
    public Set<Vendor> getAllVendor() {
        return vendorDAO.getAllVendor();
    }
}
