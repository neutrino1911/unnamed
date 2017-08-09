package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.AbstractEntityDAO;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.service.UserService;

@Service
public class UserServiceImpl extends AbstractEntityServiceImpl<User> implements UserService {

    public UserServiceImpl(AbstractEntityDAO<User> entityDAO) {
        super(entityDAO);
    }

}
