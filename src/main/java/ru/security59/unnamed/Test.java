package ru.security59.unnamed;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.security59.unnamed.entities.Vendor;

import javax.persistence.EntityManager;

public class Test {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        EntityManager entityManager = sessionFactory.createEntityManager();

        Vendor vendor = entityManager.find(Vendor.class, 1);

        entityManager.close();
        sessionFactory.close();
    }
}
