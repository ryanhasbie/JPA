package com.enigma.repository;

import com.enigma.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.function.Consumer;

public class StudentRepo extends Repo implements IRepo<Student>{

    public StudentRepo(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Student student) {
        inTransaction(em -> {
            em.persist(student);
        });
    }

//    Versi Psql
//    @Override
//    public List<Student> findAll() {
//        TypedQuery<Student> result = entityManager.createQuery("select s from Student s", Student.class);
//        List<Student> students = result.getResultList();
//
//       return students;
//    }


    // Versi Named Query
    @Override
    public List<Student> findAll(Integer page, Integer size) {
        TypedQuery<Student> result = entityManager.createNamedQuery("find all student", Student.class);
        List<Student> students = result.getResultList();

        result.setFirstResult((page -1) * size);
        result.setMaxResults(size);

        return students;
    }

    @Override
    public void update(Student student) {
        inTransaction(em -> {
            em.merge(student);
        });


//        try {
//            entityManager.getTransaction().begin();
//            entityManager.merge(student);
//            entityManager.getTransaction().commit();
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            entityManager.getTransaction().rollback();
//        }
    }

    @Override
    public Student findOne(String id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> result = entityManager.createQuery("select s from Student s where firstName like %?1%", Student.class);
        result.setParameter(1, name);
        List<Student> students = result.getResultList();
        return students;
    }

//    @Override
//    public List<Student> findByName(String name, Integer page, Integer size) {
//        TypedQuery<Student> result = entityManager.createQuery("select z from Student z where firstName=?1", Student.class);
//        result.setParameter(1, name);
//        result.setFirstResult((page -1) * size);
//        result.setMaxResults(size);
//
//        List<Student> students = result.getResultList();
//        return students;
//    }

    @Override
    public void delete(String id) {
        Student student = findOne(id);
        inTransaction(em -> {
            em.remove(student);
        });


//        try {
//            entityManager.getTransaction().begin();
//            entityManager.remove(student);
//            entityManager.getTransaction().commit();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            entityManager.getTransaction().rollback();
//            throw new RuntimeException(e);
//        }
    }


    public Student getById(String id) {
        TypedQuery<Student> result = entityManager.createNamedQuery("find student by id", Student.class);
        result.setParameter("id", id);
        return result.getSingleResult();
    }

}
