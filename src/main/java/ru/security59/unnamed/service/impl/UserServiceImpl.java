package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.UserDAO;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.service.UserService;

@Service
public class UserServiceImpl extends AbstractEntityServiceImpl<User> implements UserService {

    private final UserDAO entityDAO;

    public UserServiceImpl(UserDAO entityDAO) {
        super(entityDAO);
        this.entityDAO = entityDAO;
    }

    @Override
    public User getByLogin(String login) {
        return entityDAO.getByLogin(login);
    }
}
