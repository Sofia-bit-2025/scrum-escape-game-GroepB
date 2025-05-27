package Spel;
import Hint.*;
import Kamer.*;
import Opdracht.*;

import java.util.*;

public class GameConsole {
    private final Scanner scanner = new Scanner(System.in);
    private final Speler speler = new Speler();

    // Injectie van opdrachten via abstractie. Hint wordt binnen de opdrachten gekozen via HintFactory.
    private final Map<Integer, Kamer> kamers = Map.of(
            1, new SprintPlanning(new SprintPlanningOpdracht()),
            2, new ScrumBoard(new ScrumBoardOpdracht()),
            3, new ScrumDaily(new ScrumDailyOpdracht()),
            4, new SprintReview(new SprintReviewOpdracht()),
            5, new TiaFinaleKamer(new TiaFinaleOpdracht())
    );

    // Spel starten
    public void start() {
        System.out.println(" Welkom bij Scrum Escape Game!");
        System.out.println("Typ bijvoorbeeld: ga naar kamer 1, status of stop.");

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().toLowerCase();

            if (input.startsWith("ga naar kamer")) {
                try {
                    int nummer = Integer.parseInt(input.replaceAll("\\D+", ""));

                    if (!kamers.containsKey(nummer)) {
                        System.out.println(" Die kamer bestaat niet.");
                        continue;
                    }

                    if (!speler.magNaarKamer(nummer)) {
                        System.out.println(" Je moet eerst eerdere kamer halen.");
                        continue;
                    }

                    Kamer kamer = kamers.get(nummer);
                    kamer.betreed();               // polymorf gedrag
                    boolean geslaagd = kamer.start(); // polymorf gedrag

                    if (geslaagd) {
                        speler.kamerGehaald(nummer);
                        System.out.println(" Opdracht geslaagd!");
                    } else {
                        System.out.println(" Opdracht niet gehaald. Probeer opnieuw.");
                        System.out.println(" Als je een hint koos, heb je die net gezien.");
                        // TODO: hier later monster activeren zoals 'Vertraging' o.i.d.
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Ongeldig kamernummer. Typ bijvoorbeeld: ga naar kamer 2");
                }

                //spellerstatus bekijken
            } else if (input.equals("status")) {
                speler.toonStatus();

            } else if (input.equals("stop")) {
                System.out.println(" Tot ziens!");
                break;

            } else {
                System.out.println(" Onbekend commando. Typ bijvoorbeeld: ga naar kamer 2, status of stop.");
            }
        }
    }


    public static void main(String[] args) {
        GameConsole game = new GameConsole();
        game.start();
    }
}
