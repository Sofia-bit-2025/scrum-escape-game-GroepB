package Assistent;

import Hint.Hint;
import Hint.HintFactory;

public class KamerAssistent implements Assistent {
    private final String context;
    private final EducatiefHulpmiddelProvider uitlegProvider;
    private final MotivatieProvider motivatieProvider;

    public KamerAssistent(String context, EducatiefHulpmiddelProvider uitlegProvider, MotivatieProvider motivatieProvider) {
        this.context = context;
        this.uitlegProvider = uitlegProvider;
        this.motivatieProvider = motivatieProvider;
    }

    @Override
    public void help() {
        Hint hint = HintFactory.geefRandomHint(context);
        String uitleg = uitlegProvider.geefUitleg(context);
        String motivatie = motivatieProvider.geefMotivatie(context);

        System.out.println("Hint: " + hint);
        System.out.println("Educatief hulpmiddel: " + uitleg);
        System.out.println("Motivatie: " + motivatie);
    }
}
