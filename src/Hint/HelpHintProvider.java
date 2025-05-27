package Hint;

import java.util.Random;

public class HelpHintProvider implements HintProvider {
    private static final Random random = new Random();

    private final String[] hints = {
            // voor ScrumBoard
            "Scrum Board: check je kolommen: To Do, Doing, Done.",
            "Taken verplaatsen op het board = zicht op voortgang.",
            "Zorg dat elke taak op het bord één verantwoordelijke heeft.",

            // voor DailyScrum
            "Denk aan het doel van de Daily Scrum: synchroniseren en blokkades benoemen.",
            "Gebruik de drie standaardvragen: Wat deed je? Wat ga je doen? Wat belemmert je?",
            "Daily Scrum duurt max 15 minuten — houd het kort en krachtig.",

            // voor SprintPlanning
            "Sprint Planning? Alleen planbare taken, geen wishful thinking.",
            "Gebruik de velocity van het team om realistisch te plannen.",
            "Plan niet alles uit de backlog, maar alleen wat haalbaar is in één sprint.",

            // voor SprintReview
            "Een goede Sprint Review bespreekt wat af is én wat niet af is.",
            "Feedback van stakeholders hoort bij de Review — neem het serieus.",
            "Laat werkende software zien, geen plannen of powerpoints.",

            //voor FinaleKamer
            "Scrum is iteratief zodat je van elke sprint kunt leren en bijsturen.",
            "Iteraties zorgen voor regelmatige inspectie en aanpassing.",
            "Gebruik Retrospectives om de iteratieve cyclus te verbeteren.",

            // random!
            "De kracht van Scrum zit in transparantie, inspectie en aanpassing.",
            "Iedereen in het team is verantwoordelijk voor succes — niet alleen de Scrum Master.",
            "Scrum werkt het best als iedereen actief deelneemt, elke dag opnieuw."
    };

    @Override
    public String getHint() {//aanroepen
        return hints[random.nextInt(hints.length)];
    }
}
