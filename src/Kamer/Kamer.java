//SOLID:Interface plus Dependency
//Alle kamers hebben dezelfde structuur van methodes
//implementatie is los en werkt met kamer objecten
package Kamer;




public interface Kamer {
    void betreed();//als de speler de kamer betreedt,introductietekst tonen
    void actieUitvoeren();//nadat de kamer is betreden,vraag stellen
    String getNaam();//de naam van de kamer voor logging

}