package Hint;

import java.util.Random;

public class ScrumDailyHintProvider implements HintProvider {
    private final String[] hints = {
            "Denk aan de drie vragen: Wat heb je gedaan? Wat ga je doen? Zijn er blokkades?",  // Help
            "Scrum is geen koffiepraat – al mag het maar 15 minuten duren! "                // Funny
    };

    @Override
    public String getHint() {
        int index = new Random().nextInt(hints.length);
        return hints[index];
    }
}

