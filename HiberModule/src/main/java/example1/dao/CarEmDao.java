package example1.dao;

import example1.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CarEmDao {
    private static EntityManager em;

    public CarEmDao(EntityManagerFactory entityManagerFactory) {
        em = entityManagerFactory.createEntityManager();
    }

    public void saveCar(Car car) {
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();

    }
}
