package com.mitocode.repoImpl;

import com.mitocode.model.Paciente;
import com.mitocode.repo.ICRUD;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T,ID> {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    public T registrar(T t) {
        entityManager.persist(t);
        return t;
    }
     public void actualizar(T t ) {
        entityManager.merge(t);
    }

    public void eliminar(T t) {
        entityManager.remove(entityManager.merge(t));
    }

}
