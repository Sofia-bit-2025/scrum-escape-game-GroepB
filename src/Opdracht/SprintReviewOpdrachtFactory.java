package Opdracht;

import java.util.Scanner;

public class SprintReviewOpdrachtFactory {

    public static OpdrachtStrategy maakOpdracht(Scanner scanner) {
        return new AlgemeneOpdracht(
                scanner,
                "SprintReview",
                "Opdracht: Evalueer de feedback van stakeholders.\nWelke actie hoort bij een goede Sprint Review?",
                new String[]{
                        "Nieuwe sprintdoelen plannen",
                        "Feedback ontvangen en bespreken",
                        "De sprint beëindigen zonder overleg"
                },
                "B",
                "Juist! Een Sprint Review draait om feedback en samenwerking.",
                "Fout. In de Review wordt vooral teruggeblikt met stakeholders."
        );
    }
}
