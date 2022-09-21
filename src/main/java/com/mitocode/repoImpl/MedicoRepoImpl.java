package com.mitocode.repoImpl;

import com.mitocode.model.Medico;
import com.mitocode.repo.MedicoRepo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class MedicoRepoImpl extends CRUDImpl<Medico,Integer> implements MedicoRepo {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    @Override
    public List<Medico> listar() {
        return entityManager.createNamedQuery("Medico.listAll", Medico.class).getResultList();
    }

    @Override
    public Medico listarPorId(Medico medico) {
        return entityManager.find(Medico.class, medico.getIdMedico());
    }
}