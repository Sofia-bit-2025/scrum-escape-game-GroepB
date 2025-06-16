package Waarnemer;
import java.util.ArrayList;
import java.util.List;

public class Waarneembaar {
    private List<Waarnemer> waarnemers = new ArrayList<>();

    public void voegWaarnemersToe (Waarnemer w) {
        waarnemers.add(w);
    }

    public void updateWaarnemers (){
        for (Waarnemer w : waarnemers){
            w.update();
        }

    }

}

