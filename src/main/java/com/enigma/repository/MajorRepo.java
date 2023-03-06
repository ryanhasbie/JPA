package com.enigma.repository;

import com.enigma.model.Major;
import com.enigma.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.function.Consumer;

public class MajorRepo extends Repo implements IRepo<Major> {

    public MajorRepo(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Major major) {
        inTransaction(em -> {
            em.persist(major);
        });
    }

    @Override
    public List<Major> findAll(Integer page, Integer size) {
        TypedQuery<Major> result = entityManager.createQuery("select m from Major m", Major.class);
        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);
        List<Major> majors = result.getResultList();
        return majors;
    }

    @Override
    public void update(Major major) {
        inTransaction(em -> {
            em.merge(major);
        });
    }

    @Override
    public Major findOne(String id) {
        return entityManager.find(Major.class, id);
    }

    @Override
    public List<Major> findByName(String name) {
        TypedQuery<Major> result = entityManager.createQuery("select m from Major m where majorName like %?1%", Major.class);
        result.setParameter(1, name);
        List<Major> majors = result.getResultList();
        return majors;
    }

    @Override
    public void delete(String id) {
        inTransaction(em-> {
            Major major = findOne(id);
            em.remove(major);
        });
    }
}
