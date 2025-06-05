package Spel;

public class SpelerService {
    private final Speler speler;

    public SpelerService(Speler speler) {
        this.speler = speler;
    }

    public boolean magNaarKamer(int kamerNummer) {
        if (kamerNummer == 1) return true;
        return speler.getGehaaldeKamers().contains(kamerNummer - 1);
    }

    public void kamerGehaald(int kamerNummer) {
        speler.kamerGehaald(kamerNummer);
    }

    public int getSpelerId() {
        return speler.getSpelerId();
    }

    public Speler getSpeler() {
        return speler;
    }

    // Nieuw toegevoegd voor kamerAssistant
    public int getLaatsteBezochteKamer() {
        return speler.getLaatsteBezochteKamer();
    }
}
