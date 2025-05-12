//Deze klasse regelt de hele spelervaring via de CLI. Het vangt gebruikersinvoer op, bepaalt wat er moet gebeuren
// (kamer openen, status tonen, foutmelding geven)
// en voert dat uit door de juiste objecten aan te roepen.
//Het is de game loop die het spel "levend" maakt.

package Spel;


import Kamer.*;
import Opdracht.*;

import java.util.*;

public class GameConsole {//de centrale spelcontroller klasse
    //om invoer van de speler via de command line te lezen
    private final Scanner scanner = new Scanner(System.in);

    //oudt bij in welke kamer de speler zit, welke hij al heeft gehaald,
    // en welke obstakels actief zijn.
    private final Speler speler = new Speler();

    //een vaste mapping van kamernummers naar kamerobjecten.
    //De sleutel (Integer) is het kamernummer
    //de waarde is het object dat een specifieke kamer voorstelt (
    //het spel op basis van invoer (kamer 2)
    // precies bepalen welk kamerobject gestart moet worden
    private final Map<Integer, Kamer> kamers = Map.of(
            1, new SprintPlanning(new SprintPlanningOpdracht()),
            2, new ScrumBoard(new ScrumBoardOpdracht()),
            3, new ScrumDaily(new ScrumDailyOpdracht()),
            4, new SprintReview(new SprintReviewOpdracht()),
            5, new TiaFinaleKamer(new TiaFinaleOpdracht())
    );

    //de start() methode



    public void start() {
        System.out.println(" Welkom bij Scrum Escape Game");
        while (true) {//De hoofdloop die het spel constant laat draaien totdat de speler stop typt.
            System.out.print("\n> ");
            String input = scanner.nextLine().toLowerCase();//Leest invoer van de speler via de CLI.

            if (input.startsWith("ga naar kamer")) {//Haalt het kamernummer uit de invoer
                //alle niet-nummers worden verwijderd
                int nummer = Integer.parseInt(input.replaceAll("\\D+", ""));

                //Controleert of deze kamer bestaat in de Map<Integer, Kamer>.
                if (kamers.containsKey(nummer)) {
                    //Speler mag alleen naar een volgende kamer als de vorige voltooid is.
                    if (speler.magNaarKamer(nummer)) {
                        Kamer kamer = kamers.get(nummer);
                        kamer.betreed();
                        kamer.actieUitvoeren();
                        speler.kamerGehaald(nummer);//Speler wordt geüpdatet
                    } else {
                        //duidelijke feedback
                        System.out.println("Je moet eerst eerdere kamer halen.");
                    }
                } else {//duidelijke feedback
                    System.out.println(" Die kamer bestaat niet.");
                }

                //een overzicht van voortgang
            } else if (input.equals("status")) {
                speler.toonStatus();


            } else if (input.equals("stop")) {
                System.out.println(" Tot de volgende keer!");//Beëindigt de while lus
                break;

                //feedback bij niet-herkende commando’s
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


