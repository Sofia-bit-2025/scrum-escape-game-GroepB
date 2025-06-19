package Spel;

import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class SpelerVoortgang {
    private Set<Integer> gehaaldeKamers = new HashSet<>();
    private int huidigeKamer = 0;

    public Set<Integer> getGehaaldeKamers() {
        return gehaaldeKamers;
    }

    public int getHuidigeKamer() {
        return huidigeKamer;
    }

    public void setHuidigeKamer(int huidigeKamer) {
        this.huidigeKamer = huidigeKamer;
    }

    public void kamerGehaald(int kamerId) {
        gehaaldeKamers.add(kamerId);
    }

    public int getLaatsteBezochteKamer() {
        return gehaaldeKamers.stream().mapToInt(Integer::intValue).max().orElse(-1);
    }
}

