package Spel;

import voorwerp.Weapon;
import voorwerp.Zwaard;
import java.util.HashSet;
import java.util.Set;
import Kamer.BasisKamer;

public class Speler {
    private SpelerInfo info;
    private SpelerVoortgang voortgang;
    private Weapon wapen;
    private boolean heeftIntroGezien = false;

    public Speler(int spelerId, String gebruikersnaam) {
        this.info = new SpelerInfo(spelerId, gebruikersnaam);
        this.voortgang = new SpelerVoortgang();
        this.wapen = new Zwaard("needle");
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

    public Weapon getWapen() {
        return wapen;
    }

    public boolean isHeeftIntroGezien(){
        return heeftIntroGezien;
    }

    public void markeerIntroGezien(){
        this.heeftIntroGezien = true;
    }
    public boolean heeftVoorwerp(String naam) {
        return naam.equalsIgnoreCase("zwaard");
    }

}
