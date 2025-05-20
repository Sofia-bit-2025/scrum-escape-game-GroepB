package Spel;

import Kamer.*;
import Opdracht.*;

import java.util.*;

public class GameConsole {
    private final Scanner scanner = new Scanner(System.in);
    private final Speler speler = new Speler();

    // Alle kamers, gekoppeld aan hun nummer
    //Strategy Pattern plus  polymorfie in actie.
    private final Map<Integer, Kamer> kamers = Map.of(
            1, new SprintPlanning(new SprintPlanningOpdracht()),
            2, new ScrumBoard(new ScrumBoardOpdracht()),
            3, new ScrumDaily(new ScrumDailyOpdracht()),
            4, new SprintReview(new SprintReviewOpdracht()),
            5, new TiaFinaleKamer(new TiaFinaleOpdracht())
    );

        //spel starten
    public void start() {
        System.out.println("Welkom bij Scrum Escape Game");

        //de spel-loop
        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().toLowerCase();//wachten op een commando

            if (input.startsWith("ga naar kamer")) {//commando
                try {//alle cijfer eruithalen en een int van maken
                    int nummer = Integer.parseInt(input.replaceAll("\\D+", ""));
                    //checken of ingevoerde kamernummer bestaat
                    if (!kamers.containsKey(nummer)) {
                        System.out.println("Die kamer bestaat niet.");
                        continue;
                    }

                    //is de vorige kamer al gehaald?
                    //lineair lopen
                    if (!speler.magNaarKamer(nummer)) {
                        System.out.println("Je moet eerst eerdere kamer halen.");
                        continue;
                    }



                    Kamer kamer = kamers.get(nummer);
                    kamer.betreed(); //polymorfie
                    boolean geslaagd = kamer.start();  // boolean check //polymorfie

                    if (geslaagd) {
                        speler.kamerGehaald(nummer);
                        System.out.println("Opdracht geslaagd!");
                    } else {
                        System.out.println("Je hebt de opdracht niet gehaald. Probeer opnieuw.");
                        // hier nog  een monster activeren
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Ongeldig kamernummer. Typ bijvoorbeeld: ga naar kamer 2");
                }

            } else if (input.equals("status")) {
                speler.toonStatus();

            } else if (input.equals("stop")) {
                System.out.println("Tot ziens!");
                break;

            } else {
                System.out.println("Onbekend commando. Typ bijvoorbeeld: ga naar kamer 2, status of stop.");
            }
        }
    }

    public static void main(String[] args) {
        GameConsole game = new GameConsole();
        game.start();
    }
}
