

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    private static final String URL = "jdbc:mysql://localhost:3306/ScrumGame"; //
    private static final String USER = "root"; //
    private static final String PASSWORD = ""; //

    public static Connection maakVerbinding() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Verbinding succesvol!");
            return conn;
        } catch (SQLException e) {
            System.err.println("Verbinden met database mislukt: " + e.getMessage());
            return null;
        }
    }
}
