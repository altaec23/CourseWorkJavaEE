package example2.dao;

import example2.model.Discipline;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DisciplineDao {
    private static EntityManager em;

    public DisciplineDao(EntityManagerFactory entityManagerFactory) {
        em = entityManagerFactory.createEntityManager();
    }

    public Discipline save(Discipline discipline) {
        if (isNew(discipline)) {
            em.getTransaction().begin();
            em.persist(discipline);
            em.getTransaction().commit();
            return discipline;
        }
        em.getTransaction().begin();
        Discipline merge = em.merge(discipline);
        em.getTransaction().commit();
        return merge;
    }

    private boolean isNew(Discipline discipline) {
        return discipline.getId() == null;
    }
}
