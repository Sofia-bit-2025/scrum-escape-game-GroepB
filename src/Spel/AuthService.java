package Spel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthService {

    public static Speler login(String gebruikersnaam, String wachtwoord) {
        String sql = "SELECT id FROM gebruikers WHERE gebruikersnaam = ? AND wachtwoord = ?";
        try (Connection conn = DatabaseService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, gebruikersnaam);
            stmt.setString(2, wachtwoord);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Speler(rs.getInt("id"), gebruikersnaam);
            }

        } catch (SQLException e) {
            System.err.println("Login fout: " + e.getMessage());
        }
        return null;
    }

    public static boolean registreer(String gebruikersnaam, String wachtwoord) {
        String sql = "INSERT INTO gebruikers (gebruikersnaam, wachtwoord) VALUES (?, ?)";
        try (Connection conn = DatabaseService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, gebruikersnaam);
            stmt.setString(2, wachtwoord);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("Registratie fout: " + e.getMessage());
            return false;
        }
    }
}
