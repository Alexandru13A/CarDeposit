package ro.alexandru.DBconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static final String URL = "jdbc:mysql://localhost:3306/cardeposit";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection conn;

    public static Connection connectToDatabase() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return conn;
    }


}
