package com.realdolmen.db;

import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DbService {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("zooPu");
    private static final Logger logger = LoggerFactory.getLogger(DbService.class);
    private static DbService instance;
    private static EntityManager entityManager;

    private DbService() {
    }

    private static EntityManager getEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
            logger.info("Closing EntityManager");
        }
        logger.info("Creating EntityManager");
        entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public static DbService getInstance() {
        if (instance == null) {
            instance = new DbService();
        }
        return instance;
    }
}
