package Spel;

import java.util.HashSet;
import java.util.Set;
import Kamer.BasisKamer;

public class Speler {
    private SpelerInfo info;
    private SpelerVoortgang voortgang;

    public Speler(int spelerId, String gebruikersnaam) {
        this.info = new SpelerInfo(spelerId, gebruikersnaam);
        this.voortgang = new SpelerVoortgang();
    }

    public int getSpelerId() {
        return info.getSpelerId();
    }

    public String getGebruikersnaam() {
        return info.getGebruikersnaam();
    }

    public Set<Integer> getGehaaldeKamers() {
        return voortgang.getGehaaldeKamers();
    }

    public int getHuidigeKamer() {
        return voortgang.getHuidigeKamer();
    }

    public void setHuidigeKamer(int kamerNummer) {
        voortgang.setHuidigeKamer(kamerNummer);
    }

    public void kamerGehaald(int kamerNummer) {
        voortgang.kamerGehaald(kamerNummer);
    }

    public int getLaatsteBezochteKamer() {
        return voortgang.getLaatsteBezochteKamer();
    }
}
