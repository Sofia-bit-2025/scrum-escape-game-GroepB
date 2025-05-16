package Spel;

import java.util.*;
import java.util.stream.Collectors;

public class Speler extends StatusTemplate {
    private int spelerId = 1; // unique player ID
    private int huidigeKamer = 0;
    private final Set<Integer> voltooideKamers = new HashSet<>();

    public Speler(int spelerId) {
        this.spelerId = spelerId;
    }

    public int getSpelerId() {
        return spelerId;
    }

    public int getHuidigeKamer() {
        return huidigeKamer;
    }


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
    protected void toonHuidigeKamer() {
        System.out.println("Je bent nu in kamer: " + huidigeKamer);
    }

    protected void toonGehaaldeKamers() {
        System.out.println("Kamers gehaald: " + voltooideKamers);
    }

    // Return een String met de gehaalde kamers
    public String getGehaaldeKamersString() {
        return voltooideKamers.stream()
                .sorted()
                .map(n -> "Kamer " + n)
                .collect(Collectors.joining(", "));
    }

    // Als je voltooide kamers extern wil opvragen:
    public Set<Integer> getVoltooideKamers() {
        return Collections.unmodifiableSet(voltooideKamers);
    }
}
