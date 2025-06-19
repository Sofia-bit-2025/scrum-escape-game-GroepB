package Assistent;

import Hint.Hint;
import Hint.HintFactory;

public class AssistentFactory {

    public static KamerAssistent maakStandaardAssistent(String context) {
        EducatiefHulpmiddelProvider educatiefProvider = new DefaultEducatiefProvider();
        MotivatieProvider motivatieProvider = new DefaultMotivatieProvider();
        Hint hint = HintFactory.geefRandomHint(context);

        return new KamerAssistent(context, educatiefProvider, motivatieProvider, hint);
    }
}
