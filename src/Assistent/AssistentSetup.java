package Assistent;

public class AssistentSetup {


    public static KamerAssistent maakAssistentVoorContext(String context) {
        EducatiefHulpmiddelProvider educatiefProvider = new DefaultEducatiefProvider();
        MotivatieProvider motivatieProvider = new DefaultMotivatieProvider();

        return new KamerAssistent(context, educatiefProvider, motivatieProvider);
    }
}
