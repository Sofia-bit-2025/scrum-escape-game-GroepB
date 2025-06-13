package Kamer;

import Assistent.AssistentSetup;
import Opdracht.SprintReviewOpdrachtFactory;

import java.util.Scanner;

public class SprintReview extends BasisKamer {

    public SprintReview(Scanner scanner) {
        super(
                "SprintReview",
                "Beoordeel het resultaat.",
                SprintReviewOpdrachtFactory.maakOpdracht(scanner),
                AssistentSetup.maakAssistentVoorContext("SprintReview")
        );
    }
}
