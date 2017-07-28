package ru.security59.unnamed.service;

import java.util.Set;

public interface AbstractEntityService<T> {

    T get(Integer id);

    void add(T t);

    T update(T t);

    void delete(Integer id);

    Set<T> getAll();

}