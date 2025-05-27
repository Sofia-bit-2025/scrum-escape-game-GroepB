package Hint;

import java.util.Random;

public class FunnyHintProvider implements HintProvider {
    private static final Random random = new Random();

    private final String[] hints = {
            // voor ScrumBoard
            "Als je nog nadenkt over de taak, is hij vast niet 'Done'.",
            "Je hebt 'Doing' gehoord, maar doet nog niks.",
            "Scrum Board? Meer zoals chaosbord als je zo doorgaat.",

            //voor  DailyScrum
            "Scrum is geen koffiepraat – al mag het maar 15 minuten duren!",
            "Je bent niet op een Daily Scrum, je bent op een dagdroom.",
            "Je update was korter dan je werkdag — goed bezig!",

            // voor SprintPlanning
            "Je sprint niet als je team nog in bed ligt.",
            "Sprint Planning? Je plant alsof het een vakantie is.",
            "Alles in de backlog plannen? Rustig aan, held!",

            // voor SprintReview
            "Sprint afsluiten zonder feedback? Da’s als pizza zonder toppings.",
            "Stakeholders negeren werkt alleen in sprookjes.",
            "Review zonder discussie? Je hebt gewoon een PowerPointshow gedaan.",

            // Finale Kamer
            "Finale vraag fout? Geen zorgen, het was een iteratie.",
            "Iteraties: omdat 'één keer goed doen' alleen werkt in sprookjes.",
            "Als je dit verpest, noemen we het een retrospectieve oefening.",

            // random!!!
            "Scrummen gaat beter met koffie dan met chaos.",
            "Je team is geen sprintploeg, maar je kunt het proberen.",
            "Een fout is gewoon een user story met een twist."
    };

    @Override
    public String getHint() {
        return hints[random.nextInt(hints.length)];
    }
}
