package Spel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SpelStatusDatabase {

    public static void slaStatusOp(int spelerId, String kamerNaam, String gehaalde_kamers) {
        String sql = "INSERT INTO speler_status (speler_id, kamer_naam, gehaalde_kamers) " +
                "VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE kamer_naam = VALUES(kamer_naam), gehaalde_kamers = VALUES(gehaalde_kamers)";


        try (Connection conn = DatabaseService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, spelerId);
            stmt.setString(2, kamerNaam);
            stmt.setString(3, gehaalde_kamers);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Fout bij opslaan status: " + e.getMessage());
        }
    }
}
