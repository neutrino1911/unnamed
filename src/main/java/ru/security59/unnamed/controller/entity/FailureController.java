package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Failure;
import ru.security59.unnamed.service.FailureService;

@RestController
@RequestMapping(path = "/api/failures")
public class FailureController extends AbstractEntityController<Failure> {

    private final FailureService failureService;

    public FailureController(FailureService failureService) {
        super(failureService);
        this.failureService = failureService;
    }

}
