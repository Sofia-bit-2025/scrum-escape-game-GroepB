package Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnectie {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ScrumGame?serverTimezone=UTC&useSSL=false";
        String user = "root";
        String password = "";  // Vul hier jouw wachtwoord in

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Verbinding succesvol!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
