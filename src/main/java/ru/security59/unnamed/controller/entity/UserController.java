package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.service.UserService;

@RestController
@RequestMapping(path = "/api/users")
public class UserController extends AbstractEntityController<User> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

}
