package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.User;
import ru.security59.unnamed.service.UserService;

import javax.ws.rs.core.Response;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/users")
public class UserController extends AbstractEntityController<User> {

    private final UserService userService;

    public UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Response signUp(@RequestBody Map<String, Object> params) {
        userService.signUp(params);
        return Response.ok().build();
    }

}
