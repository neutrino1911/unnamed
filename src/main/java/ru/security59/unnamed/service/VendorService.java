package ru.security59.unnamed.service;

import ru.security59.unnamed.entities.Vendor;

import java.util.Set;

public interface VendorService {

    Vendor getVendorById(Integer id);

    void addVendor(Vendor vendor);

    Vendor updateVendor(Vendor vendor);

    void deleteVendorById(Integer id);

    Set<Vendor> getAllVendor();

}
