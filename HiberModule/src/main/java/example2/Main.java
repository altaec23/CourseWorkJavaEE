package example2;

import example1.dao.CarEmDao;
import example2.dao.DisciplineDao;
import example2.dao.GroupDao;
import example2.dao.StudentDao;
import example2.model.ContactInfo;
import example2.model.Discipline;
import example2.model.Group;
import example2.model.Student;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;

public class Main {
    private static StudentDao studentDao;
    private static DisciplineDao disciplineDao;
    private static GroupDao groupDao;

    public static void main(String[] args) {
        createAnnotationContext();
       // saveData();
       List<Student> named =  studentDao.findAllWithContactNamed();
    }

    static void createAnnotationContext() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("second_unit");
        studentDao = new StudentDao(entityManagerFactory);
        disciplineDao = new DisciplineDao(entityManagerFactory);
        groupDao = new GroupDao(entityManagerFactory);
    }

    static void saveData() {
        Discipline discipline1 = Discipline.builder().code(3).description("disc3").build();
        Discipline discipline2 = Discipline.builder().code(4).description("disc4").build();
        disciplineDao.save(discipline1);
        disciplineDao.save(discipline2);

        Group group = Group.builder().name("group3").build();
        groupDao.save(group);

        ContactInfo contactInfo = ContactInfo.builder().email("asdaas").telephoneNumber("numxber").build();
        Student student = Student.builder().name("n1ame").contact(contactInfo)
                .s_group(group)
                .disciplines(Set.of(discipline1, discipline2))
                .build();
        studentDao.save(student);

    }
}
