package ru.security59.unnamed.service;

import ru.security59.unnamed.entities.Message;

import java.util.List;

public interface MessageService extends AbstractEntityService<Message> {

    List<Message> getByUserId(Long id);
}
