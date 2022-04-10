package example1;

import example1.dao.CarDao;
import example1.dao.CarEmDao;
import example1.model.Car;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


/**
 * @author alekseev.a
 * @since 1.0
 */
public class Main {

    public static CarEmDao carDao;
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        createAnnotationContext();
        useCarDao();
    }

    public static void createAnnotationContext() {
        log.info("Hello");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("first_unit");
        carDao = new CarEmDao(entityManagerFactory);
    }

    static void useCarDao() {
        Car car = new Car("niva");
        carDao.saveCar(car);

    }


}
