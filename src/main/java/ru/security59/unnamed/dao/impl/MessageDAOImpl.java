package ru.security59.unnamed.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.MessageDAO;
import ru.security59.unnamed.entities.Message;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class MessageDAOImpl extends AbstractEntityDAOImpl<Message> implements MessageDAO {

    public MessageDAOImpl(EntityManager entityManager) {
        super(Message.class, entityManager);
    }

}
