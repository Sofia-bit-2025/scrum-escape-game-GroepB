package Hint;

/**
 * Een hint die je krijgt tijdens het spel, met een tekst én een type.
 * Bijvoorbeeld een functionele hint ("check het Scrum Board") of een grappige hint ("je doet nog niks").
 * <br>De klasse zorgt dat hints altijd netjes een tekst én een type hebben.
 */


//Deze klasse stelt een hint voor. tekst is de inhoud van de hint zelf
// en type zegt wat voor soort hint het is
//Beide velden zijn final, dus ze kunnen na het aanmaken niet meer worden aangepast.
public class Hint {
    private final String tekst;
    private final String type;


    //Deze constructor zorgt ervoor dat je geen lege of foute hint aanmaakt.
    //Als de hinttekst leeg of null is, gooit hij een foutmelding
    public Hint(String tekst, String type) {
        if (tekst == null || tekst.isBlank()) {
            throw new IllegalArgumentException("Hinttekst mag niet leeg zijn.");
        }


        //Deze regel controleert of het type wel is ingevuld.
        //Als het leeg of null is, krijg je een foutmelding.
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Hinttype mag niet leeg zijn.");
        }


        //slaan de tekst en het type van de hint op in het object
        this.tekst = tekst;
        this.type = type;
    }


    //Geeft de tekst van de hint terug.
    public String getTekst() {
        return tekst;
    }


    //Geeft het type van de hint terug
    public String getType() {
        return type;
    }


    //Maakt een nette tekstversie van de hint
    @Override
    public String toString() {
        return "[" + type + "] " + tekst;
    }
}
