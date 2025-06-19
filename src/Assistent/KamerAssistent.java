package Assistent;

import Hint.Hint;

public class KamerAssistent implements Assistent {
    private final String context;
    private final EducatiefHulpmiddelProvider uitlegProvider;
    private final MotivatieProvider motivatieProvider;
    private final Hint hint;

    public KamerAssistent(String context, EducatiefHulpmiddelProvider uitlegProvider, MotivatieProvider motivatieProvider, Hint hint) {
        this.context = context;
        this.uitlegProvider = uitlegProvider;
        this.motivatieProvider = motivatieProvider;
        this.hint = hint;
    }

    @Override
    public void help() {
        String uitleg = uitlegProvider.geefUitleg(context);
        String motivatie = motivatieProvider.geefMotivatie(context);

        System.out.println("Hint: " + hint);
        System.out.println("Educatief hulpmiddel: " + uitleg);
        System.out.println("Motivatie: " + motivatie);
    }
}
