package Spel;
//Toepassing Strategy Pattern via OpdrachtStrategy in kamerconstructors.
//Speler kan kamers betreden, opdracht uitvoeren, status bekijken.
// makkelijke uitbreiding.
//CLI besturing sluit aan bij je opdracht.
//GameConsole bestuurt spel, Kamer voert opdrachten uit.
import Kamer.*;
import Opdracht.*;

import java.util.*;

public class GameConsole {
    private final Scanner scanner = new Scanner(System.in);
    private final Speler speler = new Speler();

    private final Map<Integer, Kamer> kamers = Map.of(
            1, new SprintPlanning(new SprintPlanningOpdracht()),
            2, new ScrumBoard(new ScrumBoardOpdracht()),
            3, new ScrumDaily(new ScrumDailyOpdracht()),
            4, new SprintReview(new SprintReviewOpdracht()),
            5, new TiaFinaleKamer(new TiaFinaleOpdracht())
    );

    public void start() {
        System.out.println("Welkom bij Scrum Escape Game");
        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().toLowerCase();

            if (input.startsWith("ga naar kamer")) {
                int nummer = Integer.parseInt(input.replaceAll("\\D+", ""));
                if (kamers.containsKey(nummer)) {
                    if (speler.magNaarKamer(nummer)) {
                        Kamer kamer = kamers.get(nummer);
                        kamer.betreed();
                        kamer.actieUitvoeren();
                        speler.kamerGehaald(nummer);
                    } else {
                        System.out.println("Je moet eerst eerdere kamer halen.");
                    }
                } else {
                    System.out.println("Die kamer bestaat niet.");
                }
            } else if (input.equals("status")) {
                speler.toonStatus();
            } else if (input.equals("stop")) {
                System.out.println("Tot ziens!");
                break;
            } else {
                System.out.println("Onbekend commando.");
            }
        }
    }

    public static void main(String[] args) {
        GameConsole game = new GameConsole();
        game.start();
    }
}
