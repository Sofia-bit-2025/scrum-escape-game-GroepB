package Spel;

import Kamer.Kamer;
import monster.MonsterBasis;

import java.util.Map;
import java.util.Scanner;

public class KamerCommando {
    private final Map<Integer, Kamer> kamers;
    private final Map<Integer, Deur> deuren;
    private final Map<Integer, MonsterBasis> monsters;
    private final SpelerService spelerService;
    private final Scanner scanner;

    public KamerCommando(Map<Integer, Kamer> kamers, Map<Integer, Deur> deuren, SpelerService spelerService, Scanner scanner, Map<Integer, MonsterBasis> monsters) {
        this.kamers = kamers;
        this.deuren = deuren;
        this.spelerService = spelerService;
        this.scanner = scanner;
        this.monsters = monsters;
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

                spelerService.getSpeler().setHuidigeKamer(nummer);

                Kamer kamer = kamers.get(nummer);
                Deur deur = deuren.get(nummer);

                deur.toonGeslotenDeur();

                kamer.betreed();
                boolean gelukt = kamer.start();

                if (gelukt) {
                    System.out.println("Opdracht geslaagd! Kamer " + nummer + " gehaald.");
                    spelerService.kamerGehaald(nummer);

                    deur.update();

                    SpelStatusDatabase.slaStatusOp(
                            spelerService.getSpelerId(),
                            "Kamer " + nummer,
                            spelerService.getSpeler().getGehaaldeKamers().toString()
                    );
                } else {
                    System.out.println("Opdracht niet geslaagd. Monster wordt geactiveerd!");
                    if (monsters.containsKey(nummer)) {
                        monsters.get(nummer).valAan();
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Ongeldig kamernummer.");
            }
        } else {
            System.out.println("Onbekend commando. Typ 'help' voor opties.");
        }
    }
}
