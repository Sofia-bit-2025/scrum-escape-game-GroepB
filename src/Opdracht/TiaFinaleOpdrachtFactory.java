package Opdracht;

import java.util.Scanner;

public class TiaFinaleOpdrachtFactory {

    public static OpdrachtStrategy maakOpdracht(Scanner scanner) {
        return new AlgemeneOpdracht(
                scanner,
                "Finale",
                "Finale opdracht: Waarom werkt Scrum iteratief?",
                new String[]{
                        "Zodat alles tegelijk opgeleverd wordt",
                        "Om geleidelijk feedback te verwerken en continu te verbeteren",
                        "Omdat teams niet kunnen plannen"
                },
                "B",
                "Juist! Scrum gebruikt iteraties om continu te verbeteren.",
                "Fout. Scrum gebruikt iteraties om steeds kleine stappen te verbeteren."
        );
    }
}
