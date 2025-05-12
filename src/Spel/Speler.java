package Spel;


import java.util.*;

public class Speler {
    private int huidigeKamer = 0;
    private final Set<Integer> voltooideKamers = new HashSet<>();

    // Voeg een behaalde kamer toe
    public void kamerGehaald(int kamerNummer) {
        voltooideKamers.add(kamerNummer);
        huidigeKamer = kamerNummer;
    }

    // Check of speler naar opgegeven kamer mag
    public boolean magNaarKamer(int kamerNummer) {
        return kamerNummer == 1 || voltooideKamers.contains(kamerNummer - 1);
    }

    // Toon de huidige status van de speler
    public void toonStatus() {
        System.out.println("Je bent nu bij kamer: " + huidigeKamer);
        System.out.println("Kamers gehaald: " + voltooideKamers);
    }
}
