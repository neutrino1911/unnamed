package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.VendorDAO;
import ru.security59.unnamed.entities.Vendor;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class VendorDAOImpl extends AbstractEntityDAOImpl<Vendor> implements VendorDAO {

    public VendorDAOImpl(EntityManager entityManager) {
        super(Vendor.class, entityManager);
    }

}
