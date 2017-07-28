package ru.security59.unnamed.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Target;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/target")
public class TargetController extends AbstractController<Target> {

    public TargetController(AbstractEntityService<Target> entityService) {
        super(entityService);
    }

}
