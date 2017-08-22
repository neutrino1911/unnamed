package ru.security59.unnamed.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.service.AuthService;

import javax.ws.rs.core.Response;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Response signUp(@RequestBody Map<String, Object> params) {
        authService.signUp(params);
        return Response.ok().build();
    }


}
