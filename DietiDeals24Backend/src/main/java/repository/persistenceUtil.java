package repository;

import jakarta.persistence.EntityManagerFactory;

import jakarta.persistence.Persistence;

public class persistenceUtil {

    private static final String PERSISTENCE_UNIT_NAME = "persistence";

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}
