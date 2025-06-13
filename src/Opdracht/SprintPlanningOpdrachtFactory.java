package Opdracht;

import java.util.Scanner;

public class SprintPlanningOpdrachtFactory {

    public static OpdrachtStrategy maakOpdracht(Scanner scanner) {
        return new AlgemeneOpdracht(
                scanner,
                "SprintPlanning",
                "Wat plan je in de sprint?",
                new String[]{
                        "Bugs oplossen",
                        "Wat het team kan afronden",
                        "Alles in de backlog"
                },
                "B",
                "Correct! Je plant alleen wat het team realistisch kan afronden.",
                "Fout! Je plant geen willekeurige bugs of alles uit de backlog."
        );
    }
}
