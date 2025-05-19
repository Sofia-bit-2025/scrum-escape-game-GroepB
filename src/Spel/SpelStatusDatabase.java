package Spel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SpelStatusDatabase {

    public static void slaStatusOp(int spelerId, String kamerNaam, String status) {
        String sql = "INSERT INTO speler_status (speler_id, kamer_naam, status) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, spelerId);
            stmt.setString(2, kamerNaam);
            stmt.setString(3, status);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Fout bij opslaan status: " + e.getMessage());
        }
    }
}
