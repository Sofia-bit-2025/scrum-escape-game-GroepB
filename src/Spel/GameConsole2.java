package Spel;

import Hint.*;
import Kamer.*;
import Opdracht.*;

import java.util.*;

public class GameConsole {
    private final Scanner scanner = new Scanner(System.in);
    private final Speler speler = new Speler();
    private final Map<Integer, Kamer> kamers = new LinkedHashMap<>();

    public GameConsole() {
        // Kamers aanmaken met bijbehorende opdrachten (scanner wordt meegegeven)
        kamers.put(1, new SprintPlanning(new SprintPlanningOpdracht(scanner)));
        kamers.put(2, new ScrumBoard(new ScrumBoardOpdracht(scanner)));
        kamers.put(3, new ScrumDaily(new ScrumDailyOpdracht(scanner)));
        kamers.put(4, new SprintReview(new SprintReviewOpdracht(scanner)));
        kamers.put(5, new TiaFinaleKamer(new TiaFinaleOpdracht(scanner)));
    }

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
                    kamer.betreed();
                    boolean geslaagd = kamer.start();

                    if (geslaagd) {
                        speler.kamerGehaald(nummer);
                        System.out.println(" Opdracht geslaagd!");
                    } else {
                        System.out.println(" Opdracht niet gehaald. Probeer opnieuw.");
                        System.out.println(" Als je een hint koos, heb je die net gezien.");
                        // TODO: hier later monster activeren
                    }

                } catch (NumberFormatException e) {
                    System.out.println(" Ongeldig kamernummer. Typ bijvoorbeeld: ga naar kamer 2");
                }

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
