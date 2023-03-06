package com.enigma.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Factory {
    private static String PERSISTENCE_NAME = "defaul";
    private static EntityManagerFactory emFactory;

    public static void getFactory() {
        emFactory = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
    }

    public static EntityManager start() {
        if (emFactory == null) {
            getFactory();
        }
        return emFactory.createEntityManager();
    }
}

// dengan menggunakan JPA kita bisa mendifinisikan sebuah class menjadi entitas/entity. Dan dengan JPA kita bisa mengurai penulisan query database

// sehingga hal tersebut bisa mengurangi interaksi secara langsung dengan database
