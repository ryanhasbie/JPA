package com.enigma.repository;

import com.enigma.model.Student;
import com.enigma.model.UserCredential;
import jakarta.persistence.EntityManager;

import java.util.function.Consumer;

public class UserCredentialRepo implements IUserCredentialRepo {
    EntityManager entityManager;

    public UserCredentialRepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    private void inTransaction(Consumer<EntityManager> consumer) {
        try {
            entityManager.getTransaction().begin();
            consumer.accept(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void update(UserCredential userCredential) {
        inTransaction(em -> {
            em.merge(userCredential);
        });
    }
}
