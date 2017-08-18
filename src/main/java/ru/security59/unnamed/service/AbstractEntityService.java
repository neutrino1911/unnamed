package ru.security59.unnamed.service;

import java.util.List;
import java.util.Map;

public interface AbstractEntityService<T> {

    T get(Long id);

    void add(T t);

    T update(T t);

    void delete(Long id);

    List<T> getAll();

    List<T> getList(Map<Object, Object> params);

}