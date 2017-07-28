package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.FailureDAO;
import ru.security59.unnamed.entities.Failure;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class FailureDAOImpl extends AbstractEntityDAOImpl<Failure> implements FailureDAO {

    public FailureDAOImpl(EntityManager entityManager) {
        super(Failure.class, entityManager);
    }

}
