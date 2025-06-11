package Kamer;

import Assistent.AssistentFactory;
import Opdracht.OpdrachtStrategy;

public class SprintReview extends BasisKamer {

    public SprintReview(OpdrachtStrategy opdracht) {
        super(
                "SprintReview",
                "Beoordeel het resultaat.",
                opdracht,
                AssistentFactory.maakStandaardAssistent("SprintReview")
        );
    }
}
