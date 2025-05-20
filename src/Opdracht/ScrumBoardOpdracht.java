package Opdracht;

import java.util.Scanner;

public class ScrumBoardOpdracht implements OpdrachtStrategy {

    @Override
    public boolean voerUit() {
        System.out.println("Opdracht: Waar hoort de taak 'abstracte klasse controleren' op het Scrum Board?");
        System.out.println("A) To Do");
        System.out.println("B) Doing");
        System.out.println("C) Done");

        //Speler om input vragen
        Scanner scanner = new Scanner(System.in);
        System.out.print("> Jouw antwoord: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();//spatie weg/hoofdletter

        // Pak alleen de eerste letter, bijv. bij B) Doing
        if (antwoord.length() > 0) {
            antwoord = antwoord.substring(0, 1);
        }


        //antwoord checken
        if (antwoord.equals("B")) {
            System.out.println("Correct! Deze taak hoort bij 'Doing'.");
            return true;
        } else {
            System.out.println("Fout. Het juiste antwoord was: B) Doing.");
            // speler.voegMonsterToe(new Vertraging())  nog toevoegen
            return false;
        }
    }
}
