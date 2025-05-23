package Hint;

import java.util.Random;

public class TiaFinaleKamerHintprovider implements HintProvider {
    private final String[] hints = {
            "Scrum is iteratief zodat je van elke sprint kunt leren en bijsturen.",  // Help
            "Iteraties: omdat 'één keer en perfect' alleen werkt in sprookjes "     // Funny
    };

    @Override
    public String getHint() {
        int index = new Random().nextInt(hints.length);
        return hints[index];
    }
}
