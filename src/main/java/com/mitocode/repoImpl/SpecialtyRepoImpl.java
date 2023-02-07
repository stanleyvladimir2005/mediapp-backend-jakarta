package com.mitocode.repoImpl;

import com.mitocode.model.Specialty;
import com.mitocode.repo.SpecialtyRepo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class SpecialtyRepoImpl extends CRUDImpl<Specialty,Integer> implements SpecialtyRepo {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    @Override
    public List<Specialty> findAll() {
        return entityManager.createNamedQuery("Specialty.listAll", Specialty.class).getResultList();
    }

    @Override
    public Specialty findById(Specialty specialty) {
        return entityManager.find(Specialty.class, specialty.getIdSpecialty());
    }
}