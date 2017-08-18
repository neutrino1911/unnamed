package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.UserDAO;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.entities.User_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
@Transactional
public class UserDAOImpl extends AbstractEntityDAOImpl<User> implements UserDAO {

    public UserDAOImpl(EntityManager entityManager) {
        super(User.class, entityManager);
    }

    @Override
    public User getByLogin(String login) {
        CriteriaQuery<User> criteria = criteriaBuilder.createQuery(type);
        Root<User> root = criteria.from(type);
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get(User_.login), login));
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
