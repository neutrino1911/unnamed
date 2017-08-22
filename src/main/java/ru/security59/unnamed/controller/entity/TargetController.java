package ru.security59.unnamed.controller.entity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.security59.unnamed.entities.Target;
import ru.security59.unnamed.service.TargetService;

@RestController
@RequestMapping(path = "/api/targets")
public class TargetController extends AbstractEntityController<Target> {

    private final TargetService targetService;

    public TargetController(TargetService targetService) {
        super(targetService);
        this.targetService = targetService;
    }

}
