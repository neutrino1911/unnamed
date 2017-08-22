package ru.security59.unnamed.service.impl;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.UserDAO;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.entities.enums.UserRole;
import ru.security59.unnamed.service.UserService;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl extends AbstractEntityServiceImpl<User> implements UserService {

    private final UserDAO userDAO;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDAO userDAO) {
        super(userDAO);
        this.userDAO = userDAO;
        this.passwordEncoder = new ShaPasswordEncoder(256);
    }

    @Override
    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    @Override
    public void signUp(Map<String, Object> params) {
        User user = new User();
        user.setLogin((String) params.get("login"));
        user.setName((String) params.get("username"));
        String password = (String) params.get("password");
        String salt = passwordEncoder.encodePassword(password, null).substring(0, 20);
        user.setSalt(salt);
        String hash = passwordEncoder.encodePassword(password, salt);
        user.setPassword(hash);
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.USER);
        user.setRoles(roles);
        userDAO.add(user);
    }

}
