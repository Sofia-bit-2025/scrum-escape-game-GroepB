package Spel;

import Kamer.*;
import Opdracht.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class FactoryKamer {

    public static Map<Integer, Kamer> maakKamers() {
        Map<Integer, Kamer> kamers = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        kamers.put(1, new SprintPlanning(new SprintPlanningOpdracht(scanner)));
        kamers.put(2, new ScrumBoard(new ScrumBoardOpdracht(scanner)));
        kamers.put(3, new ScrumDaily(new ScrumDailyOpdracht(scanner)));
        kamers.put(4, new SprintReview(new SprintReviewOpdracht(scanner)));
        kamers.put(5, new TiaFinaleKamer(new TiaFinaleOpdracht(scanner)));

        return kamers;
    }
}
