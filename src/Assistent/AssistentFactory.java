package Assistent;

import Hint.Hint;

public class AssistentFactory {

    public static KamerAssistent maakStandaardAssistent(String context) {
        return new KamerAssistent(
                context,
                new DefaultEducatiefProvider(),
                new DefaultMotivatieProvider(),
                new Hint(),

        );
    }
}

//hint toevoegen nog