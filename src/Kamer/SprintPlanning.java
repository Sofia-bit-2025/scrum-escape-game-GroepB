package Kamer;

import Assistent.*;
import Opdracht.OpdrachtStrategy;


public class SprintPlanning extends BasisKamer {


    public SprintPlanning(OpdrachtStrategy opdracht) {
        super(
                "SprintPlanning",
                "Plan de sprint.",
                opdracht,
                new KamerAssistent(
                        "SprintPlanning", // context
                        new DefaultEducatiefProvider(),
                        new DefaultMotivatieProvider()
                )
        );
    }
}
