package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.UserDAO;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.service.UserService;

@Service
public class UserServiceImpl extends AbstractEntityServiceImpl<User> implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        super(userDAO);
        this.userDAO = userDAO;
    }

    @Override
    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

}
