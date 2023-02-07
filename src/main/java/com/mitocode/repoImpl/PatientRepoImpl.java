package com.mitocode.repoImpl;

import com.mitocode.model.Patient;
import com.mitocode.repo.PatientRepo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class PatientRepoImpl extends CRUDImpl<Patient,Integer> implements PatientRepo {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    @Override
    public List<Patient> findAll() {
        return entityManager.createNamedQuery("Patient.listAll", Patient.class).getResultList();
    }

    @Override
    public Patient findById(Patient patient) {
        return entityManager.find(Patient.class, patient.getIdPatient());
    }
}