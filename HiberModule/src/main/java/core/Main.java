package core;

import core.model.City;
import core.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author alekseev.a
 * @since 1.0
 */
public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        log.info("Hello");
        var serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        var metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        createRecord(User.builder().name("name").build(), sessionFactory);

        var session = sessionFactory.openSession();
        List<City> list = session.createQuery("from core.model.City", City.class).list();
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
