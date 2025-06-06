package Assistent;

public class AssistentFactory {

    public static KamerAssistent maakStandaardAssistent(String context) {
        return new KamerAssistent(
                context,
                new DefaultEducatiefProvider(),
                new DefaultMotivatieProvider()
        );
    }
}
