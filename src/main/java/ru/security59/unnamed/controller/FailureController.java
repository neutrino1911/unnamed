package ru.security59.unnamed.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Failure;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/failure")
public class FailureController extends AbstractController<Failure> {

    public FailureController(AbstractEntityService<Failure> entityService) {
        super(entityService);
    }

}
