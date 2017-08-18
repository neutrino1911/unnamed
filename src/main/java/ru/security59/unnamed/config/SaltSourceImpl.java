package ru.security59.unnamed.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.service.UserService;

@Service
public class SaltSourceImpl implements SaltSource {

    private final UserService userService;

    @Autowired
    public SaltSourceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object getSalt(UserDetails userDetails) {
        User user = userService.getByLogin(userDetails.getName());
        return user.getSalt();
    }
}
