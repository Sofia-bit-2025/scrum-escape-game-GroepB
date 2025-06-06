package Hint;

import java.util.List;

public class HelpHintProvider extends AbstractHintProvider {

    @Override
    protected List<Hint> getAllHints() {
        return List.of(
                // ScrumBoard
                new Hint("ScrumBoard: Scrum Board: check je kolommen: To Do, Doing, Done.", "help"),
                new Hint("ScrumBoard: Taken verplaatsen op het board = zicht op voortgang.", "help"),
                new Hint("ScrumBoard: Zorg dat elke taak op het bord één verantwoordelijke heeft.", "help"),

                // DailyScrum
                new Hint("DailyScrum: Denk aan het doel van de Daily Scrum: synchroniseren en blokkades benoemen.", "help"),
                new Hint("DailyScrum: Gebruik de drie standaardvragen: Wat deed je? Wat ga je doen? Wat belemmert je?", "help"),
                new Hint("DailyScrum: Daily Scrum duurt max 15 minuten — houd het kort en krachtig.", "help"),

                // SprintPlanning
                new Hint("SprintPlanning: Sprint Planning? Alleen planbare taken, geen wishful thinking.", "help"),
                new Hint("SprintPlanning: Gebruik de velocity van het team om realistisch te plannen.", "help"),
                new Hint("SprintPlanning: Plan niet alles uit de backlog, maar alleen wat haalbaar is in één sprint.", "help"),

                // SprintReview
                new Hint("SprintReview: Een goede Sprint Review bespreekt wat af is én wat niet af is.", "help"),
                new Hint("SprintReview: Feedback van stakeholders hoort bij de Review — neem het serieus.", "help"),
                new Hint("SprintReview: Laat werkende software zien, geen plannen of powerpoints.", "help"),

                // Finale
                new Hint("Finale: Scrum is iteratief zodat je van elke sprint kunt leren en bijsturen.", "help"),
                new Hint("Finale: Iteraties zorgen voor regelmatige inspectie en aanpassing.", "help"),
                new Hint("Finale: Gebruik Retrospectives om de iteratieve cyclus te verbeteren.", "help"),

                // Random (geen prefix)
                new Hint("De kracht van Scrum zit in transparantie, inspectie en aanpassing.", "help"),
                new Hint("Iedereen in het team is verantwoordelijk voor succes — niet alleen de Scrum Master.", "help"),
                new Hint("Scrum werkt het best als iedereen actief deelneemt, elke dag opnieuw.", "help")
        );
    }
}
