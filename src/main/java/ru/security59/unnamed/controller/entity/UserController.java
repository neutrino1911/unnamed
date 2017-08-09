package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/users")
public class UserController extends AbstractEntityController<User> {

    public UserController(AbstractEntityService<User> entityService) {
        super(entityService);
    }

}
