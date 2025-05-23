package Hint;

import java.util.Random;

public class SprintReviewHintProvider implements HintProvider {
    private final String[] hints = {
            "Een Sprint Review draait om inspectie en aanpassing, gebaseerd op feedback.",  // HelpHint
            "Sprint afsluiten zonder overleg? Da's als pizza zonder toppings "          // FunnyHint
    };

    @Override
    public String getHint() {
        int index = new Random().nextInt(hints.length);
        return hints[index];
    }
}
