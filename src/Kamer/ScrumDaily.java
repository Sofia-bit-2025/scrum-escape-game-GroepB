package Kamer;

import Assistent.*;
import Opdracht.OpdrachtStrategy;

public class ScrumDaily extends BasisKamer {

    public ScrumDaily(OpdrachtStrategy opdracht) {
        super(
                "Daily Scrum",
                "Iedereen geeft een korte statusupdate.",
                opdracht,
                new KamerAssistent(
                        "DailyScrum", // context
                        new DefaultEducatiefProvider(),
                        new DefaultMotivatieProvider()
                )
        );
    }
}
