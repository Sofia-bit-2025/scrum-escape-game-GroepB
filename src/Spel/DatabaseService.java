package Spel;

import java.sql.*;

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

    public static Speler login(String gebruikersnaam, String wachtwoord) {
        String sql = "SELECT id, gebruikersnaam FROM gebruikers WHERE gebruikersnaam = ? AND wachtwoord = ?";
        try {
            // Gebruik de singleton connectie
            Connection connection = getConnection();
            if (connection == null) {
                System.err.println("Geen databaseverbinding.");
                return null;
            }

            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, gebruikersnaam);
                stmt.setString(2, wachtwoord);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int spelerId = rs.getInt("id");
                    String naam = rs.getString("gebruikersnaam");
                    System.out.println("Login succesvol! Welkom, " + naam);
                    Speler ingelogdeSpeler = new Speler(spelerId, naam);
                    Speler.setIngelogdeSpeler(ingelogdeSpeler);
                    return ingelogdeSpeler;
                } else {
                    System.out.println("Ongeldige gebruikersnaam of wachtwoord.");
                    return null;
                }
            }

        } catch (SQLException e) {
            System.err.println("Login mislukt: " + e.getMessage());
            return null;
        }
    }
    public static boolean registreer(String gebruikersnaam, String wachtwoord) {
        String sql = "INSERT INTO gebruikers (gebruikersnaam, wachtwoord) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, gebruikersnaam);
            stmt.setString(2, wachtwoord);

            stmt.executeUpdate();
            System.out.println("Registratie succesvol!");
            return true;

        } catch (SQLException e) {
            if (e.getMessage().contains("Duplicate")) {
                System.out.println("Gebruikersnaam bestaat al.");
            } else {
                System.err.println("Registratie mislukt: " + e.getMessage());
            }
            return false;
        }
    }
    public static boolean registreerSpeler(String gebruikersnaam, String wachtwoord) {
        String sql = "INSERT INTO gebruikers (gebruikersnaam, wachtwoord) VALUES (?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, gebruikersnaam);
            stmt.setString(2, wachtwoord);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Registratie mislukt: " + e.getMessage());
            return false;
        }
    }

}
