package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.TargetDAO;
import ru.security59.unnamed.entities.Target;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class TargetDAOImpl extends AbstractEntityDAOImpl<Target> implements TargetDAO {

    public TargetDAOImpl(EntityManager entityManager) {
        super(Target.class, entityManager);
    }

}
