package Spel;
import Kamer.Kamer;
import java.util.Scanner;
import java.util.Map;

public class KamerCommando {
 private final Map<Integer, Kamer> kamers;
 private final SpelerService spelerService;
 private final Scanner scanner;

 public KamerCommando(Map<Integer, Kamer> kamers, SpelerService spelerService, Scanner scanner) {
     this.kamers = kamers;
     this.spelerService = spelerService;
     this.scanner = scanner;
 }


    public void verwerkKamerCommando(String input) {
        if (input.startsWith("ga naar kamer")) {
            try {
                int nummer = Integer.parseInt(input.replaceAll("\\D+", ""));
                if (!kamers.containsKey(nummer)) {
                    System.out.println("Die kamer bestaat niet.");
                    return;
                }
                if (!spelerService.magNaarKamer(nummer)) {
                    System.out.println("Je moet eerst eerdere kamer(s) halen.");
                    return;
                }

                Kamer kamer = kamers.get(nummer);
                kamer.betreed();
                boolean gelukt = kamer.start();

                if (gelukt) {
                    System.out.println("Opdracht geslaagd! Kamer " + nummer + " gehaald.");
                    spelerService.kamerGehaald(nummer);
                    SpelStatusDatabase.slaStatusOp(
                            spelerService.getSpelerId(),
                            "Kamer " + nummer,
                            spelerService.getSpeler().getGehaaldeKamers().toString()
                    );
                } else {
                    System.out.println("Opdracht niet geslaagd. Probeer opnieuw.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Ongeldig kamernummer.");
            }
        } else {
            System.out.println("Onbekend commando. Typ 'help' voor opties.");
        }
    }
}