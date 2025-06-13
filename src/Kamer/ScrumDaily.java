package Kamer;

import Assistent.AssistentSetup;
import Opdracht.OpdrachtStrategy;
import Opdracht.ScrumDailyOpdrachtFactory;

import java.util.Scanner;

public class ScrumDaily extends BasisKamer {

    public ScrumDaily(Scanner scanner) {
        super(
                "Daily Scrum",
                "Iedereen geeft een korte statusupdate.",
                ScrumDailyOpdrachtFactory.maakOpdracht(scanner),
                AssistentSetup.maakAssistentVoorContext("DailyScrum")
        );
    }
}
