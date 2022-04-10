package example1;

import example1.dao.CarDao;
import example1.model.Car;
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

    public static CarDao carDao;
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        createAnnotationContext();
        useCarDao();
    }

    public static void createAnnotationContext() {
        log.info("Hello");
        var serviceRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        var metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        carDao = new CarDao(sessionFactory);
    }

    static void useCarDao() {
        Car car = carDao.createRecord(new Car("jiguli"));
        car.setModel("newJiguli");
        carDao.updateRecord(car);
        List<Car> resultList = carDao.findAll();
        System.out.println("car1 = " + resultList);
    }


}
