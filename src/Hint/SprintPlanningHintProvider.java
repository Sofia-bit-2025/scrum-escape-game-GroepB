package Hint;

import java.util.Random;

public class SprintPlanningHintProvider implements HintProvider {
    private final String[] hints = {
            "Plan alleen wat het team realistisch kan afronden. Neem de velocity als basis.",  // help
            "Niet alles wat backlogt, moet geplanned worden. Je bent geen superheld "        // funny
    };

    @Override
    public String getHint() {
        int index = new Random().nextInt(hints.length);
        return hints[index];
    }
}

