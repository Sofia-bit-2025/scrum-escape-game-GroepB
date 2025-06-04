package Hint;

/**
 * Een strategie-interface voor het filteren van hints op basis van contextuele criteria.
 */
public interface HintFilterStrategy {

    boolean accepteert(String hintTekst, String context);
}


