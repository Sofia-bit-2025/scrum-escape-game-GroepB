package Kamer;

import Assistent.*;
import Opdracht.OpdrachtStrategy;


public class TiaFinaleKamer extends BasisKamer {


    public TiaFinaleKamer(OpdrachtStrategy opdracht) {
        super(
                "Finale Kamer: TIA",                    // kamernaam
                "Beantwoord vragen.",                   // instructie
                opdracht,                               // opdrachtstrategie DIP
                new KamerAssistent(                     // assistent
                        "Finale Kamer: TIA",            // context (moet exact matchen met provider-switch)
                        new DefaultEducatiefProvider(),
                        new DefaultMotivatieProvider()
                )
        );
    }
}
