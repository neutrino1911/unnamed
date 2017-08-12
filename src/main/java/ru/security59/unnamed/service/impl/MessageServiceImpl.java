package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.MessageDAO;
import ru.security59.unnamed.entities.Message;
import ru.security59.unnamed.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl extends AbstractEntityServiceImpl<Message> implements MessageService {

    private final MessageDAO entityDAO;

    public MessageServiceImpl(MessageDAO entityDAO) {
        super(entityDAO);
        this.entityDAO = entityDAO;
    }

    @Override
    public List<Message> getByUserId(Long id) {
        return entityDAO.getByUserId(id);
    }

}
