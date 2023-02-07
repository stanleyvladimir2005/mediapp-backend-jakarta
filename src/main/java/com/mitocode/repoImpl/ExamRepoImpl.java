package com.mitocode.repoImpl;

import com.mitocode.model.Exam;
import com.mitocode.repo.ExamRepo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class ExamRepoImpl extends CRUDImpl<Exam,Integer> implements ExamRepo {

    @PersistenceContext(unitName = "postgres")
    private EntityManager entityManager;

    @Override
    public List<Exam> findAll() {
        return entityManager.createNamedQuery("Exam.listAll", Exam.class).getResultList();
    }

    @Override
    public Exam findById(Exam exam) {
        return entityManager.find(Exam.class, exam.getIdExam());
    }
}