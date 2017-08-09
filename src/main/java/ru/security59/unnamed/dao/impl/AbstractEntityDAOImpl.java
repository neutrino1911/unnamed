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

    private final Class<T> type;

    final EntityManager entityManager;

    final CriteriaBuilder criteriaBuilder;

    AbstractEntityDAOImpl(Class<T> type, EntityManager entityManager) {
        this.type = type;
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    @Override
    public T get(Integer id) {
        return entityManager.find(type, id);
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
        T t = entityManager.find(type, id);
        if (t != null) {
            entityManager.remove(t);
        }
    }

    @Override
    public List<T> getAll() {
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(type);
        Root<T> root = criteria.from(type);
        criteria.select(root);
        return entityManager.createQuery(criteria).getResultList();
    }

    @Override
    public List<T> getList(Integer page, Integer count) {
        Integer start = (page - 1) * count;
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(type);
        Root<T> root = criteria.from(type);
        criteria.select(root);
        return entityManager.createQuery(criteria).setFirstResult(start).setMaxResults(count).getResultList();
    }
}
