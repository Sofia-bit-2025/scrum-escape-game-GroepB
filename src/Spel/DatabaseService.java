package Spel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    private static final String URL = "jdbc:mysql://localhost:3306/ScrumGame";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conn;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Verbinding met database succesvol!");
            } catch (SQLException e) {
                System.err.println("Verbinden met database mislukt: " + e.getMessage());
            }
        }
        return conn;
    }
}
