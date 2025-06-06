package Kamer;

import Assistent.AssistentFactory;
import Opdracht.OpdrachtStrategy;

public class ScrumBoard extends BasisKamer {

    public ScrumBoard(OpdrachtStrategy opdracht) {
        super(
                "ScrumBoard",
                "Gebruik het Scrum Board om je voortgang te visualiseren.",
                opdracht,
                AssistentFactory.maakStandaardAssistent("ScrumBoard")
        );
    }
}
