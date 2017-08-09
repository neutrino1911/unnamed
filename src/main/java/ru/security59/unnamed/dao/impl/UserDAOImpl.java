package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.UserDAO;
import ru.security59.unnamed.entities.User;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class UserDAOImpl extends AbstractEntityDAOImpl<User> implements UserDAO {

    public UserDAOImpl(EntityManager entityManager) {
        super(User.class, entityManager);
    }

}
