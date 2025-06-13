package Opdracht;

import java.util.Scanner;

public class ScrumDailyOpdrachtFactory {

    public static OpdrachtStrategy maakOpdracht(Scanner scanner) {
        return new AlgemeneOpdracht(
                scanner,
                "DailyScrum",
                "Opdracht: Wat wordt besproken tijdens een Daily Scrum?",
                new String[]{
                        "Gedetailleerde sprintplanning",
                        "Wat ieder teamlid gedaan heeft, gaat doen, en blokkades",
                        "Retrospective feedback"
                },
                "B",
                "Correct! Dat is precies de bedoeling van een Daily Scrum.",
                "Fout. Het juiste antwoord was: B) Wat ieder teamlid gedaan heeft, gaat doen, en blokkades."
        );
    }
}
