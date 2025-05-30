//In deze opdrachtklasse wordt de hint opgevraagd via
// de interface HintProvider, gekozen door HintFactory.
// Er is geen directe koppeling met concrete hintklassen,
// en de logica voor hintselectie is verplaatst naar de Factory.
// Dit is volledig in lijn met het Dependency Inversion Principle
// en voldoet aan alle acceptatiecriteria van User Story 20.
package Opdracht;


import Hint.HintFactory;
import Hint.HintProvider;

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

        // Pak alleen de eerste letter, bijv. bij B) doing
        if (antwoord.length() > 0) {
            antwoord = antwoord.substring(0, 1);
        }


        //antwoord checken
        if (antwoord.equals("B")) {
            System.out.println("Correct! Deze taak hoort bij 'Doing'.");
            return true;
        } else {
            System.out.println("Fout. Het juiste antwoord was: B) Doing.");
            System.out.print("Wil je een hint? (ja/nee): ");
            String keuze = scanner.nextLine().trim().toLowerCase();
            if (keuze.equals("ja")) {
                HintProvider hintProvider = HintFactory.createRandomHintProvider();
                System.out.println("Hint: " + hintProvider.getHint());
            }
            return false;
        }




    }

}
