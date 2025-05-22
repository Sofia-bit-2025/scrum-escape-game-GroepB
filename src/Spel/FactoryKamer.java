package Spel;

import Kamer.*;
import Opdracht.*;

import java.util.Map;
import java.util.HashMap;

public class FactoryKamer {
    public static Map<Integer, Kamer> maakKamers() {
        Map<Integer, Kamer> kamers = new HashMap<>();
        kamers.put(1, new SprintPlanning(new SprintPlanningOpdracht()));
        kamers.put(2, new ScrumBoard(new ScrumBoardOpdracht()));
        kamers.put(3, new ScrumDaily(new ScrumDailyOpdracht()));
        kamers.put(4, new SprintReview(new SprintReviewOpdracht()));
        kamers.put(5, new TiaFinaleKamer(new TiaFinaleOpdracht()));
        return kamers;
    }
}
