package Spel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SpelStatusDatabase {

    public static void slaStatusOp(int spelerId, String huidigeKamer, String gehaaldeKamers) {
        Connection conn = DatabaseService.getConnection();

        if (conn == null) {
            System.out.println("Geen databaseverbinding.");
            return;
        }

        String sql = "INSERT INTO speler_status (speler_id, huidige_kamer, gehaalde_kamers) VALUES (?, ?, ?) " +
                "ON DUPLICATE KEY UPDATE huidige_kamer = VALUES(huidige_kamer), gehaalde_kamers = VALUES(gehaalde_kamers)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, spelerId);
            stmt.setString(2, huidigeKamer);
            stmt.setString(3, gehaaldeKamers);
            stmt.executeUpdate();
            System.out.println("Status succesvol opgeslagen!");
        } catch (SQLException e) {
            System.out.println("Fout bij opslaan status: " + e.getMessage());
        }
    }
}
