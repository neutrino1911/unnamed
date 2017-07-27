package ru.security59.unnamed.dao;

import ru.security59.unnamed.entities.Vendor;

import java.util.Set;

public interface VendorDAO {

    Vendor getVendorById(Integer id);

    void addVendor(Vendor vendor);

    Vendor updateVendor(Vendor vendor);

    void deleteVendorById(Integer id);

    Set<Vendor> getAllVendor();

}
