package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.AbstractEntityDAO;
import ru.security59.unnamed.entities.Message;
import ru.security59.unnamed.service.MessageService;

@Service
public class MessageServiceImpl extends AbstractEntityServiceImpl<Message> implements MessageService {

    public MessageServiceImpl(AbstractEntityDAO<Message> entityDAO) {
        super(entityDAO);
    }
}
