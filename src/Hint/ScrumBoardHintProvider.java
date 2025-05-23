package Hint;



import java.util.Random;

public class ScrumBoardHintProvider implements HintProvider {
    private final String[] hints = {
            "Denk aan de kolommen: To Do, Doing, Done.",  // HelpHint
            "Als je nog nadenkt over de taak, is hij vast niet 'Done' " // FunnyHint
    };

    @Override
    public String getHint() {
        int index = new Random().nextInt(hints.length); // willekeurige keuze
        return hints[index];
    }
}