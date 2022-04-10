package example2.dao;

import example2.model.Group;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class GroupDao {
    private static EntityManager em;

    public GroupDao(EntityManagerFactory entityManagerFactory) {
        em = entityManagerFactory.createEntityManager();
    }

    public Group save(Group group) {
        if (isNew(group)) {
            em.getTransaction().begin();
            em.persist(group);
            em.getTransaction().commit();
            return group;
        }
        em.getTransaction().begin();
        Group merge = em.merge(group);
        em.getTransaction().commit();
        return merge;
    }

    private boolean isNew(Group group) {
        return group.getId() == null;
    }
}
