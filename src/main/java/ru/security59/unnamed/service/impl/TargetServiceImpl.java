package ru.security59.unnamed.service.impl;

import org.springframework.stereotype.Service;
import ru.security59.unnamed.dao.AbstractEntityDAO;
import ru.security59.unnamed.entities.Target;
import ru.security59.unnamed.service.TargetService;

@Service
public class TargetServiceImpl extends AbstractEntityServiceImpl<Target> implements TargetService {

    public TargetServiceImpl(AbstractEntityDAO<Target> entityDAO) {
        super(entityDAO);
    }

}
