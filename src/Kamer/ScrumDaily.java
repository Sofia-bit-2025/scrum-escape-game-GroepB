package Kamer;

import Assistent.AssistentFactory;
import Opdracht.OpdrachtStrategy;

public class ScrumDaily extends BasisKamer {

    public ScrumDaily(OpdrachtStrategy opdracht) {
        super(
                "Daily Scrum",
                "Iedereen geeft een korte statusupdate.",
                opdracht,
                AssistentFactory.maakStandaardAssistent("DailyScrum")
        );
    }

    @Override
    public boolean start() {
        return false;
    }
}
