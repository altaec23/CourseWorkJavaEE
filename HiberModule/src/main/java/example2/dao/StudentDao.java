package example2.dao;

import example2.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StudentDao {
    private static EntityManager em;

    public StudentDao(EntityManagerFactory entityManagerFactory) {
        em = entityManagerFactory.createEntityManager();
    }

    public Student save(Student student) {
        if (isNew(student)) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            return student;
        }
        em.getTransaction().begin();
        Student merge = em.merge(student);
        em.getTransaction().commit();
        return merge;
    }

    public List<Student> findAll() {
        return em.createQuery("select student from example2.model.Student student", Student.class)
                .getResultList();
    }

    public  List<Student> findAllWithContactNamed(){
        return em.createNamedQuery("Student.findAllWithContact", Student.class).getResultList();
    }
    public List<Student> findById(Long id) {
        return em.createQuery("select student from example2.model.Student student where student.id = :id", Student.class)
                .setParameter("id", id)
                .getResultList();
    }

    private boolean isNew(Student group) {
        return group.getId() == null;
    }
}
