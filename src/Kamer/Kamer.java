package Kamer;


public abstract class Kamer {
    protected final String naam;


    public Kamer(String naam) {
        this.naam = naam;
    }


    public abstract void betreed();


    public abstract boolean start();


    public String getNaam() {
        return naam;
    }
}
