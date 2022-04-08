import model.City;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * @author alekseev.a
 * @since 1.0
 */
public class Main {

/*    public static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    public static final String USER = "postgres";
    public static final String PASSWORD = "postgres";*/


    public static void main(String[] args) {
        var serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        var metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        createRecord(User.builder().name("name").build(), sessionFactory);

        var session = sessionFactory.openSession();
        List<City> list = session.createQuery("from model.City", City.class).list();
        System.out.println(list);
    }

    private static <T> T createRecord(T record, SessionFactory factory) {
        var session = factory.openSession();
        var transaction = session.beginTransaction();
        session.save(record);
        transaction.commit();
        session.close();
        return record;
    }

}
