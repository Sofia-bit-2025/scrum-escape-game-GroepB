package Kamer;

import Assistent.AssistentFactory;
import Opdracht.OpdrachtStrategy;

public class TiaFinaleKamer extends BasisKamer {

    public TiaFinaleKamer(OpdrachtStrategy opdracht) {
        super(
                "Finale Kamer: TIA",
                "Beantwoord vragen.",
                opdracht,
                AssistentFactory.maakStandaardAssistent("Finale Kamer: TIA")
        );
    }
}
