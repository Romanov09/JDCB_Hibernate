package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class Util {
    //    реализуем настройку с бд
    private static final String URL = "jdbc:mysql://localhost:3306/lesson_1";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "Roman";
    private static final String PASSWORD = "09030";
    private static SessionFactory sessionFactory = null;


    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration()
                        .setProperty("hibernate.connection.driver_class", DRIVER)
                        .setProperty("hibernate.connection.url", URL)
                        .setProperty("hibernate.connection.username", USERNAME)
                        .setProperty("hibernate.connection.password", PASSWORD)
                        .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                        .addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}

//try {
//            Driver driver = new com.mysql.cj.jdbc.Driver();
//            DriverManager.registerDriver(driver);
//
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//
////            if (!connection.isClosed()) {
////                System.out.println("Start OK");
////            }
////            connection.close();
////            if (connection.isClosed()) {
////                System.out.println("Close OK");
////            }
//        } catch (SQLException e1) {
//            System.out.println("Driver connection failed");
//        }