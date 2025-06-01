package Hint;

import java.util.ArrayList;
import java.util.List;

public class FunnyHintProvider implements HintProvider {

    @Override
    public List<Hint> getHintsForContext(String context) {
        List<Hint> result = new ArrayList<>();

        // Alle hints met context-prefix
        List<Hint> allHints = List.of(
                new Hint("ScrumBoard: Als je nog nadenkt over de taak, is hij vast niet 'Done'.", "grappig"),
                new Hint("ScrumBoard: Je hebt 'Doing' gehoord, maar doet nog niks.", "grappig"),
                new Hint("ScrumBoard: Scrum Board? Meer zoals chaosbord als je zo doorgaat.", "grappig"),

                new Hint("DailyScrum: Scrum is geen koffiepraat – al mag het maar 15 minuten duren!", "grappig"),
                new Hint("DailyScrum: Je bent niet op een Daily Scrum, je bent op een dagdroom.", "grappig"),
                new Hint("DailyScrum: Je update was korter dan je werkdag — goed bezig!", "grappig"),

                new Hint("SprintPlanning: Je sprint niet als je team nog in bed ligt.", "grappig"),
                new Hint("SprintPlanning: Sprint Planning? Je plant alsof het een vakantie is.", "grappig"),
                new Hint("SprintPlanning: Alles in de backlog plannen? Rustig aan, held!", "grappig"),

                new Hint("SprintReview: Sprint afsluiten zonder feedback? Da’s als pizza zonder toppings.", "grappig"),
                new Hint("SprintReview: Stakeholders negeren werkt alleen in sprookjes.", "grappig"),
                new Hint("SprintReview: Review zonder discussie? Je hebt gewoon een PowerPointshow gedaan.", "grappig"),

                new Hint("Finale: Finale vraag fout? Geen zorgen, het was een iteratie.", "grappig"),
                new Hint("Finale: Iteraties: omdat 'één keer goed doen' alleen werkt in sprookjes.", "grappig"),
                new Hint("Finale: Als je dit verpest, noemen we het een retrospectieve oefening.", "grappig"),

                // Random hints zonder context
                new Hint("Scrummen gaat beter met koffie dan met chaos.", "grappig"),
                new Hint("Je team is geen sprintploeg, maar je kunt het proberen.", "grappig"),
                new Hint("Een fout is gewoon een user story met een twist.", "grappig")
        );

        // Filter op context via prefix (mag ook met ContextPrefixFilter als je die erin injecteert)
        for (Hint hint : allHints) {
            if (hint.getTekst().startsWith(context + ":")) {
                result.add(hint);
            }
        }

        return result;
    }
}
