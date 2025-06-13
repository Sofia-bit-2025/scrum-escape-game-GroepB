package Opdracht;

import java.util.Scanner;

public class ScrumBoardOpdrachtFactory {

    public static OpdrachtStrategy maakOpdracht(Scanner scanner) {
        return new AlgemeneOpdracht(
                scanner,
                "ScrumBoard",
                "Opdracht: Waar hoort de taak 'abstracte klasse controleren' op het Scrum Board?",
                new String[]{"To Do", "Doing", "Done"},
                "B",
                "Correct! Deze taak hoort bij 'Doing'.",
                "Fout. Het juiste antwoord was: B) Doing."
        );
    }
}
