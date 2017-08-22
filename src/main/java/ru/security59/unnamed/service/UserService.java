package ru.security59.unnamed.service;

import ru.security59.unnamed.entities.User;

import java.util.Map;

public interface UserService extends AbstractEntityService<User> {

    User getByLogin(String login);

    void signUp(Map<String, Object> params);

}
