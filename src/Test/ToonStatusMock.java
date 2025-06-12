package Test;

import Spel.StatusTemplate;

public class ToonStatusMock extends StatusTemplate {

    private String huidigeKamer;
    private String[] gehaaldeKamers;

    public ToonStatusMock(String huidigeKamer, String[] gehaaldeKamers) {
        this.huidigeKamer = huidigeKamer;
        this.gehaaldeKamers = gehaaldeKamers;
    }

    @Override
    protected void toonHuidigeKamer() {
        System.out.println("Huidige kamer: " + (huidigeKamer != null ? huidigeKamer : "geen"));
    }

    @Override
    protected void toonGehaaldeKamers() {
        if (gehaaldeKamers == null || gehaaldeKamers.length == 0) {
            System.out.println("Geen kamers gehaald.");
        } else {
            System.out.print("Gehaalde kamers: ");
            for (String kamer : gehaaldeKamers) {
                System.out.print(kamer + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 🎯 Limit test 1: geen kamers
        ToonStatusMock mock1 = new ToonStatusMock(null, new String[]{});
        mock1.toonHuidigeKamer();
        mock1.toonGehaaldeKamers();

        // 🎯 Limit test 2: één kamer
        ToonStatusMock mock2 = new ToonStatusMock("Kamer 1", new String[]{"Kamer 1"});
        mock2.toonHuidigeKamer();
        mock2.toonGehaaldeKamers();

        // 🎯 Limit test 3: meerdere kamers
        ToonStatusMock mock3 = new ToonStatusMock("Kamer 3", new String[]{"Kamer 1", "Kamer 2"});
        mock3.toonHuidigeKamer();
        mock3.toonGehaaldeKamers();
    }
}
