package ru.security59.unnamed.dao;

import java.util.Set;

public interface AbstractEntityDAO<T> {

    T get(Integer id);

    void add(T t);

    T update(T t);

    void delete(Integer id);

    Set<T> getAll();

}