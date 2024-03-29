package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.FailureDAO;
import ru.security59.unnamed.entities.Failure;
import ru.security59.unnamed.service.FailureService;

@Service
public class FailureServiceImpl extends AbstractEntityServiceImpl<Failure> implements FailureService {

    private final FailureDAO failureDAO;

    public FailureServiceImpl(FailureDAO failureDAO) {
        super(failureDAO);
        this.failureDAO = failureDAO;
    }

}
