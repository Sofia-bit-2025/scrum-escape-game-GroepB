package Kamer;

import Assistent.*;
import Opdracht.OpdrachtStrategy;


public class SprintReview extends BasisKamer {


    public SprintReview(OpdrachtStrategy opdracht) {
        super(
                "SprintReview",
                "Beoordeel het resultaat.",
                opdracht,
                new KamerAssistent(
                        "SprintReview", // context voor hints/uitleg/motivatie
                        new DefaultEducatiefProvider(),
                        new DefaultMotivatieProvider()
                )
        );
    }
}
