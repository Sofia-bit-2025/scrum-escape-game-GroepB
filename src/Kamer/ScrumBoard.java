package Kamer;

import Assistent.*;
import Opdracht.OpdrachtStrategy;


public class ScrumBoard extends BasisKamer {


    public ScrumBoard(OpdrachtStrategy opdracht) {
        super(
                "ScrumBoard", // Naam van de kamer
                "Richt het bord in met taken en user stories.", // Instructie
                opdracht,
                new KamerAssistent( // Dependency Injection van de assistent
                        "ScrumBoard", // context voor hints/uitleg/motivatie
                        new DefaultEducatiefProvider(),
                        new DefaultMotivatieProvider()
                )
        );
    }
}
