package com.mitocode.repoImpl;

import com.mitocode.model.Medic;
import com.mitocode.repo.MedicRepo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class MedicRepoImpl extends CRUDImpl<Medic,Integer> implements MedicRepo {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    @Override
    public List<Medic> findAll() {
        return entityManager.createNamedQuery("Medic.listAll", Medic.class).getResultList();
    }

    @Override
    public Medic findById(Medic medic) {
        return entityManager.find(Medic.class, medic.getIdMedic());
    }
}