package com.mitocode.repoImpl;

import com.mitocode.repo.ICRUD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class CRUDImpl<T, ID> implements ICRUD<T,ID> {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    public T save(T t) {
        entityManager.persist(t);
        return t;
    }
     public void update(T t ) {
        entityManager.merge(t);
    }

    public void delete(T t) {
        entityManager.remove(entityManager.merge(t));
    }
}