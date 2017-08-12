package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.MessageDAO;
import ru.security59.unnamed.entities.Message;
import ru.security59.unnamed.entities.Message_;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Transactional
public class MessageDAOImpl extends AbstractEntityDAOImpl<Message> implements MessageDAO {

    public MessageDAOImpl(EntityManager entityManager) {
        super(Message.class, entityManager);
    }

    @Override
    public List<Message> getByUserId(Long id) {
        CriteriaQuery<Message> criteria = criteriaBuilder.createQuery(type);
        Root<Message> root = criteria.from(type);
        criteria.select(root);
        criteria.where(criteriaBuilder.equal(root.get(Message_.from), id));
        return entityManager.createQuery(criteria).getResultList();
    }
}
