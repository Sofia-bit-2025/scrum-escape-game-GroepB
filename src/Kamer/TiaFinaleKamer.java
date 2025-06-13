package Kamer;

import Assistent.AssistentSetup;
import Opdracht.TiaFinaleOpdrachtFactory;

import java.util.Scanner;

public class TiaFinaleKamer extends BasisKamer {

    public TiaFinaleKamer(Scanner scanner) {
        super(
                "Finale Kamer: TIA",
                "Beantwoord vragen.",
                TiaFinaleOpdrachtFactory.maakOpdracht(scanner),
                AssistentSetup.maakAssistentVoorContext("Finale Kamer: TIA")
        );
    }
}
