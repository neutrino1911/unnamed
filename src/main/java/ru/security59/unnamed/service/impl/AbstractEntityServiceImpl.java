package ru.security59.unnamed.service.impl;

import ru.security59.unnamed.dao.AbstractEntityDAO;
import ru.security59.unnamed.service.AbstractEntityService;

import java.util.Set;

public class AbstractEntityServiceImpl<T> implements AbstractEntityService<T> {

    private final AbstractEntityDAO<T> entityDAO;

    AbstractEntityServiceImpl(AbstractEntityDAO<T> entityDAO) {
        this.entityDAO = entityDAO;
    }

    @Override
    public T get(Integer id) {
        return entityDAO.get(id);
    }

    @Override
    public void add(T t) {
        entityDAO.add(t);
    }

    @Override
    public T update(T t) {
        return entityDAO.update(t);
    }

    @Override
    public void delete(Integer id) {
        entityDAO.delete(id);
    }

    @Override
    public Set<T> getAll() {
        return entityDAO.getAll();
    }
}
