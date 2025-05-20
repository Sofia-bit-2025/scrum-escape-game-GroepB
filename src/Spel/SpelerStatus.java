package Spel;

public class SpelerStatus extends StatusTemplate {
    private final Speler speler;

    public SpelerStatus(Speler speler) {
        this.speler = speler;
    }

    @Override
    protected void toonHuidigeKamer() {
        System.out.println("Huidige kamer: " + speler.getHuidigeKamer());
    }

    @Override
    protected void toonGehaaldeKamers() {
        if (speler.getGehaaldeKamers().isEmpty()) {
            System.out.println("Je hebt nog geen kamers gehaald.");
        } else {
            System.out.println("Gehaalde kamers: " + speler.getGehaaldeKamers().toString());
        }
    }
}
