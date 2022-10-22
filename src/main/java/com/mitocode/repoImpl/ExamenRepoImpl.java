package com.mitocode.repoImpl;

import com.mitocode.model.Examen;
import com.mitocode.repo.ExamenRepo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ExamenRepoImpl extends CRUDImpl<Examen,Integer> implements ExamenRepo {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    @Override
    public List<Examen> listar() {
        return entityManager.createNamedQuery("Examen.listAll", Examen.class).getResultList();
    }

    @Override
    public Examen listarPorId(Examen examen) {
        return entityManager.find(Examen.class, examen.getIdExamen());
    }
}