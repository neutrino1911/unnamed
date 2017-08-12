package ru.security59.unnamed.dao;

import java.util.List;
import java.util.Map;

public interface AbstractEntityDAO<T> {

    T get(Integer id);

    void add(T t);

    T update(T t);

    void delete(Integer id);

    List<T> getAll();

    List<T> getList(Map<Object, Object> params);
}
