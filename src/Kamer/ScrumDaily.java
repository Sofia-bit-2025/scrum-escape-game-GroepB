//toont instructies aan de speler en roept een actie
// op die aansluit bij dat Scrumevent.

//Door OOP en SOLID toe te passen is deze klasse:
//gescheiden van andere logica (SRP),
//vervangbaar of uitbreidbaar
package Kamer;
import java.util.Scanner;

public class ScrumDaily implements Kamer {
    private final String naam = "Daily Scrum";
    private final String instructie = "Iedereen geeft een korte statusupdate.";

    @Override
    public void betreed() {
        System.out.println("Je betreedt: " + naam);
        System.out.println(instructie);
    }

    @Override
    public void actieUitvoeren() {
        System.out.println("Wat bespreek je tijdens een Daily Scrum?");
        System.out.println("A) De product backlog aanpassen\nB) Wat je gisteren deed, vandaag gaat doen en blokkades\nC) De sprint verlengen");
        Scanner scanner = new Scanner(System.in);
        String antwoord = scanner.nextLine();
        if (antwoord.equalsIgnoreCase("B")) {
            System.out.println("✅ Correct! Dagelijkse stand-ups gaan daarover.");
        } else {
            System.out.println("❌ Fout. Een Daily Scrum bespreekt voortgang en blokkades.");
        }
    }

    @Override
    public String getNaam() {
        return naam;
    }
}