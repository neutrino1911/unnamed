package ru.security59.unnamed.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import ru.security59.unnamed.dao.AbstractEntityDAO;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Transactional
public abstract class AbstractEntityDAOImpl<T> implements AbstractEntityDAO<T> {

    private final Class<T> typeParameterClass;

    final EntityManager entityManager;

    final CriteriaBuilder criteriaBuilder;

    AbstractEntityDAOImpl(Class<T> typeParameterClass, EntityManager entityManager) {
        this.typeParameterClass = typeParameterClass;
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @Override
    public T get(Integer id) {
        return entityManager.find(typeParameterClass, id);
    }

    @Override
    public void add(T t) {
        entityManager.persist(t);
    }

    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public void delete(Integer id) {
        T t = entityManager.find(typeParameterClass, id);
        if (t != null) {
            entityManager.remove(t);
        }
    }

    @Override
    public List<T> getAll() {
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(typeParameterClass);
        Root<T> root = criteria.from(typeParameterClass);
        criteria.select(root);
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List<T> getList(Integer page, Integer count) {
        Integer start = (page - 1) * count;
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(typeParameterClass);
        Root<T> root = criteria.from(typeParameterClass);
        criteria.select(root);
        return entityManager.createQuery(criteria).setFirstResult(start).setMaxResults(count).getResultList();
    }
}
