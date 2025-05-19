package Spel;

import java.util.HashSet;
import java.util.Set;

public class Speler {

    private int spelerId;
    private String gebruikersnaam;
    private Set<Integer> gehaaldeKamers;  // kamers die speler gehaald heeft
    private int huidigeKamer;

    // Static variabele om huidige ingelogde speler te onthouden
    private static Speler ingelogdeSpeler = null;

    // Constructor met id en gebruikersnaam (pas aan naar behoefte)
    public Speler(int spelerId, String gebruikersnaam) {
        this.spelerId = spelerId;
        this.gebruikersnaam = gebruikersnaam;
        this.gehaaldeKamers = new HashSet<>();
        this.huidigeKamer = 0; // begin kamer 0 of 1 zoals nodig
    }

    public int getSpelerId() {
        return spelerId;
    }

    public String getGebruikersnaam() {
        return gebruikersnaam;
    }

    public Set<Integer> getGehaaldeKamers() {
        return gehaaldeKamers;
    }

    public int getHuidigeKamer() {
        return huidigeKamer;
    }

    public void setHuidigeKamer(int kamerNummer) {
        this.huidigeKamer = kamerNummer;
    }

    public void kamerGehaald(int kamerNummer) {
        gehaaldeKamers.add(kamerNummer);
        huidigeKamer = kamerNummer;
    }

    public String getGehaaldeKamersString() {
        return gehaaldeKamers.toString();
    }

    public boolean magNaarKamer(int kamerNummer) {
        // voorbeeld check: mag alleen naar kamer 1 als het de eerste kamer is
        // en mag pas naar volgende kamers als vorige gehaald is
        if (kamerNummer == 1) return true;
        return gehaaldeKamers.contains(kamerNummer - 1);
    }

    // Static methods voor ingelogde speler
    public static Speler getIngelogdeSpeler() {
        return ingelogdeSpeler;
    }

    public static void setIngelogdeSpeler(Speler speler) {
        ingelogdeSpeler = speler;
    }

    public static void logout() {
        ingelogdeSpeler = null;
    }

    // Voor debuggen / status printen
    public void toonHuidigeKamer() {
        System.out.println("Huidige kamer: " + huidigeKamer);
    }

    public void toonGehaaldeKamers() {
        System.out.println("Gehaalde kamers: " + getGehaaldeKamersString());
    }
}
