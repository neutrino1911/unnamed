package ru.security59.unnamed.service;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.UserDAO;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.entities.enums.UserRole;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserDAO userDAO;

    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
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
