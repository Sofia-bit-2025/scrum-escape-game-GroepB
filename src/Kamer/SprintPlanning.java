package Kamer;

import Assistent.AssistentFactory;
import Opdracht.OpdrachtStrategy;

public class SprintPlanning extends BasisKamer {

    public SprintPlanning(OpdrachtStrategy opdracht) {
        super(
                "SprintPlanning",
                "Plan de sprint.",
                opdracht,
                AssistentFactory.maakStandaardAssistent("SprintPlanning")
        );
    }

    @Override
    public boolean start() {
        return false;
    }
}
