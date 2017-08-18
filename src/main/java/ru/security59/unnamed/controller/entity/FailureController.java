package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Failure;
import ru.security59.unnamed.service.AbstractEntityService;

@RestController
@RequestMapping(path = "/api/failures")
public class FailureController extends AbstractEntityController<Failure> {

    public FailureController(AbstractEntityService<Failure> entityService) {
        super(entityService);
    }

}
