package Spel;

import Kamer.*;
import java.util.*;

public class GameConsole {

    private final Scanner scanner = new Scanner(System.in);
    private final Speler speler = new Speler(1);

    private final Map<Integer, Kamer> kamers = Map.of(
            1, new SprintPlanning(),
            2, new ScrumBoard(),
            3, new ScrumDaily(),
            4, new SprintReview(),
            5, new TiaFinaleKamer()
    );

    public void start() {
        System.out.println("Welkom bij Scrum Escape Game!");
        toonHelpMenu();

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().toLowerCase();

            if (input.startsWith("ga naar kamer")) {
                try {
                    int nummer = Integer.parseInt(input.replaceAll("\\D+", ""));
                    if (kamers.containsKey(nummer)) {
                        if (speler.magNaarKamer(nummer)) {
                            Kamer kamer = kamers.get(nummer);
                            kamer.betreed();
                            kamer.actieUitvoeren();
                            speler.kamerGehaald(nummer);


                            SpelStatusDatabase.slaStatusOp(
                                    speler.getSpelerId(),
                                    "Kamer " + nummer,
                                    speler.getGehaaldeKamersString()
                            );

                        } else {
                            System.out.println("Je moet eerst eerdere kamer(s) halen.");
                        }
                    } else {
                        System.out.println("Die kamer bestaat niet.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ongeldig kamer nummer.");
                }
            } else if (input.equals("status")) {
                speler.toonHuidigeKamer();
                speler.toonGehaaldeKamers();
                System.out.println("Speler ID: " + speler.getSpelerId());
                System.out.println("Gehaalde kamers (netjes): " + speler.getGehaaldeKamersString());
            } else if (input.equals("help")) {
                toonHelpMenu();
            } else if (input.equals("stop")) {
                System.out.println("Tot de volgende keer!");
                break;
            } else {
                System.out.println("Onbekend commando.");
            }
        }
    }

    private void toonHelpMenu() {
        System.out.println("\n--- Beschikbare commando's ---");
        System.out.println("ga naar kamer [nummer]  - Om een kamer te betreden, bijv. 'ga naar kamer 1'");
        System.out.println("status                  - Bekijk je voortgang");
        System.out.println("help                    - Toon dit helpmenu");
        System.out.println("stop                    - Stop het spel");
    }

    public static void main(String[] args) {
        GameConsole game = new GameConsole();
        game.start();
    }
}
