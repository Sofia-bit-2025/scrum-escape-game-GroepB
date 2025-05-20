package Spel;

import Kamer.Kamer;
import java.util.Map;
import java.util.Scanner;

public class GameConsole {
    private final Scanner scanner = new Scanner(System.in);
    private final SpelerService spelerService;
    private final Map<Integer, Kamer> kamers;
    private final SpelerStatus spelerStatus;

    public GameConsole(Speler speler) {
        this.spelerService = new SpelerService(speler);
        this.kamers = Spel.maakKamers();
        this.spelerStatus = new SpelerStatus(speler);
    }

    public void start() {
        System.out.println("Welkom bij Scrum Escape Game!");
        toonHelpMenu();

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "help" -> toonHelpMenu();
                case "status" -> {
                    spelerStatus.toonStatus();
                }
                case "stop" -> {
                    System.out.println("Tot de volgende keer!");
                    return;
                }
                default -> verwerkKamerCommando(input);
            }
        }
    }

    private void verwerkKamerCommando(String input) {
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

    private void toonHelpMenu() {
        System.out.println("\n--- Beschikbare commando's ---");
        System.out.println("ga naar kamer [nummer]");
        System.out.println("status");
        System.out.println("help");
        System.out.println("stop");
    }
}
