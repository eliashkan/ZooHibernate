package com.realdolmen.db;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbService {

    private static final Logger logger = LoggerFactory.getLogger(DbService.class);
    private static EntityManagerFactory entityManagerFactory = null;
    private static EntityManager entityManager = null;

    private static String persistenceUnitName;

    public static String setPersistenceUnitName(String persistenceUnitName) {
        DbService.persistenceUnitName = persistenceUnitName;
        return persistenceUnitName;
    }

    public static EntityManager getEntityManager() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
            logger.info("Closing EntityManagerFactory");
        }
        logger.info("Creating EntityManagerFactory");
        entityManagerFactory =
                Persistence.createEntityManagerFactory(persistenceUnitName);

        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
            logger.info("Closing EntityManager");
        }
        logger.info("Creating EntityManager");
        entityManager = DbService.entityManagerFactory.createEntityManager();

        return entityManager;
    }

//      Not necessary to apply the singleton pattern: all variables and methods are already static
//      so 'new DbService' will never create more than one instance of the fields
//    public static DbService getInstance() {
//        if (instance == null) {
//            instance = new DbService();
//        }
//        return instance;
//    }
}
