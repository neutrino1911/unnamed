package ru.security59.unnamed.service;

import ru.security59.unnamed.entities.User;

public interface UserService extends AbstractEntityService<User> {

    User getByLogin(String login);

}
