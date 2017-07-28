package ru.security59.unnamed.dao;

import java.util.List;

public interface AbstractEntityDAO<T> {

    T get(Integer id);

    void add(T t);

    T update(T t);

    void delete(Integer id);

    List<T> getAll();

    List<T> getList(Integer page, Integer count);

}
