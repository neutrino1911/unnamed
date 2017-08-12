package ru.security59.unnamed.dao;

import ru.security59.unnamed.entities.Message;

import java.util.List;

public interface MessageDAO extends AbstractEntityDAO<Message> {

    List<Message> getByUserId(Long id);
}
