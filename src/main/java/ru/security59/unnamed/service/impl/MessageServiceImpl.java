package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.MessageDAO;
import ru.security59.unnamed.entities.Message;
import ru.security59.unnamed.service.MessageService;

import java.util.List;

@Service
public class MessageServiceImpl extends AbstractEntityServiceImpl<Message> implements MessageService {

    private final MessageDAO messageDAO;

    public MessageServiceImpl(MessageDAO messageDAO) {
        super(messageDAO);
        this.messageDAO = messageDAO;
    }

    @Override
    public List<Message> getByUserId(Long id) {
        return messageDAO.getByUserId(id);
    }

}
