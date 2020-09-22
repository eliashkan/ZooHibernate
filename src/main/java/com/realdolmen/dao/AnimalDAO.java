package com.realdolmen.dao;

import com.realdolmen.model.Animal;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

import javax.persistence.EntityManager;

import static com.realdolmen.db.DbService.getEntityManager;
import static javax.persistence.FlushModeType.AUTO;

public class AnimalDAO {

    private static final Logger logger = LoggerFactory.getLogger(AnimalDAO.class);

    public static Animal save(Animal animal) {

        EntityManager entityManager = getEntityManager();
        entityManager.setFlushMode(AUTO);

        // Check db if animal exists already, if so: merge.
        // Otherwise: persist the new animal.
        Animal foundAnimal = entityManager.find(Animal.class, animal.getId());
        if (foundAnimal != null) {
            logger.info("Found animal already present in Db: merging.");
            return entityManager.merge(animal);
        } else {
            logger.info("Persisting new animal");
            entityManager.persist(animal);
        }

        return animal;
    }

    public static Animal findById(int id) throws AnimalNotFoundException {
        EntityManager entityManager = getEntityManager();
        Animal animal = entityManager.find(Animal.class, id);
        if (animal == null) {
            throw new AnimalNotFoundException();
        } else {
            return animal;
        }
    }

    public static Animal find(Animal animal) throws AnimalNotFoundException {
        EntityManager entityManager = getEntityManager();
        return findById(animal.getId());
    }
}
