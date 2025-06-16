package Spel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

    private static final String URL = "jdbc:mysql://localhost:3306/ScrumGame";
    private static final String USER = "root";
    private static final String PASSWORD = "B!12P!12Pini!03";

    /**
     * Geeft een nieuwe verbinding naar de database.
     * Deze verbinding moet door de aanroeper worden gesloten (bijv. via try-with-resources).
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
