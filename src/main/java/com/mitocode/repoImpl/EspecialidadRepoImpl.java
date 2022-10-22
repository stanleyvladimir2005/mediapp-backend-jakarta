package com.mitocode.repoImpl;

import com.mitocode.model.Especialidad;
import com.mitocode.repo.EspecialidadRepo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EspecialidadRepoImpl extends CRUDImpl<Especialidad,Integer> implements EspecialidadRepo {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    @Override
    public List<Especialidad> listar() {
        return entityManager.createNamedQuery("Especialidad.listAll", Especialidad.class).getResultList();
    }

    @Override
    public Especialidad listarPorId(Especialidad especialidad) {
        return entityManager.find(Especialidad.class, especialidad.getIdEspecialidad());
    }
}