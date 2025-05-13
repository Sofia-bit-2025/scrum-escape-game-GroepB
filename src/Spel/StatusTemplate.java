package Spel;

public abstract class StatusTemplate {
    public final void toonStatus() {
    toonHuidigeKamer();
    toonGehaaldeKamers();
     }

protected abstract void toonHuidigeKamer();
protected abstract void toonGehaaldeKamers();
}
