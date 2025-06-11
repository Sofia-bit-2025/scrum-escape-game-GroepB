package Spel;

import java.util.HashSet;
import java.util.Set;
import Kamer.BasisKamer;

public class Speler {
    private int spelerId;
    private String gebruikersnaam;
    private Set<Integer> gehaaldeKamers = new HashSet<>();
    private int huidigeKamer = 0;

    public Speler(int spelerId, String gebruikersnaam) {
        this.spelerId = spelerId;
        this.gebruikersnaam = gebruikersnaam;
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

   //Nieuw toegevoegde methode voor kamer assistant
    public int getLaatsteBezochteKamer() {
        return huidigeKamer;
    }
}
