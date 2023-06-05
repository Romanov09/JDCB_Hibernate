package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    //реализуем настройку с бд
    private static final String URL = "jdbc:mysql://localhost:3306/lesson_1";
    private static final String USERNAME = "Roman";
    private static final String PASSWORD = "09030";


    public static Connection getConnection() {
        Connection connection = null;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

//            if (!connection.isClosed()) {
//                System.out.println("Start OK");
//            }
//            connection.close();
//            if (connection.isClosed()) {
//                System.out.println("Close OK");
//            }
        } catch (SQLException e1) {
            System.out.println("Driver connection failed");
        }

        return connection;
    }

}
