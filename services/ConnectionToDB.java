package studentHelper.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Evgeny on 4/9/17.
 */
public class ConnectionToDB {
    private static String URL = "jdbc:mysql://localhost:3306/student_helper";
    private static String USERNAME = "root";
    private static String PASSWORD = "root";

    protected Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
