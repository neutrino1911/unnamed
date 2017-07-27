package ru.security59.unnamed.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.VendorDAO;
import ru.security59.unnamed.entities.Vendor;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional
public class VendorDAOImpl implements VendorDAO {

    private final EntityManager entityManager;

    @Autowired
    public VendorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Vendor getVendorById(Integer id) {
        return entityManager.find(Vendor.class, id);
    }

    @Override
    public void addVendor(Vendor vendor) {
        entityManager.persist(vendor);
    }

    @Override
    public Vendor updateVendor(Vendor vendor) {
        return entityManager.merge(vendor);
    }

    @Override
    public void deleteVendorById(Integer id) {
        Vendor vendor = entityManager.find(Vendor.class, id);
        if (vendor != null) {
            entityManager.remove(vendor);
        }
    }

    @Override
    public Set<Vendor> getAllVendor() {
        return new HashSet<>(entityManager.createQuery(
                entityManager.getCriteriaBuilder().createQuery(Vendor.class)).getResultList());
    }
}