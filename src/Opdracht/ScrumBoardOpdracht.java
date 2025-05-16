package Opdracht;

import java.util.Scanner;

public class ScrumBoardOpdracht implements OpdrachtStrategy {

    @Override
    public void voerUit() {
        System.out.println(" Opdracht: Waar hoort de taak 'abstract klasse controleren' op het Scrum Board?");
        System.out.println("A) To Do");
        System.out.println("B) Doing");
        System.out.println("C) Done");

        Scanner scanner = new Scanner(System.in);
        System.out.print("> Jouw antwoord: ");
        String antwoord = scanner.nextLine().trim().toUpperCase();

        // Enkel eerste letter accepteren, ook bij invoer zoals "B) Doing"
        if (antwoord.length() > 0) {
            antwoord = antwoord.substring(0, 1);
        }

        if (antwoord.equals("B")) {
            System.out.println("Correct! 'Test feature' hoort bij 'Doing'.");
        } else {
            System.out.println("Fout. Het juiste antwoord was: B) Doing.");
            //hier nog een monster activeren.... ik heb nu geen monster klass
        }
    }
}
