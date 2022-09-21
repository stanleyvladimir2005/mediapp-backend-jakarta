package com.mitocode.repoImpl;

import com.mitocode.model.Paciente;
import com.mitocode.repo.PacienteRepo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class PacienteRepoImpl extends CRUDImpl<Paciente,Integer> implements PacienteRepo {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    @Override
    public List<Paciente> listar() {
        return entityManager.createNamedQuery("Paciente.listAll", Paciente.class).getResultList();
    }

    @Override
    public Paciente listarPorId(Paciente paciente) {
        return entityManager.find(Paciente.class, paciente.getIdPaciente());
    }
}