package Kamer;

import Assistent.AssistentSetup;
import Opdracht.SprintPlanningOpdrachtFactory;

import java.util.Scanner;

public class SprintPlanning extends BasisKamer {

    public SprintPlanning(Scanner scanner) {
        super(
                "SprintPlanning",
                "Plan de sprint.",
                SprintPlanningOpdrachtFactory.maakOpdracht(scanner),
                AssistentSetup.maakAssistentVoorContext("SprintPlanning")
        );
    }
}
