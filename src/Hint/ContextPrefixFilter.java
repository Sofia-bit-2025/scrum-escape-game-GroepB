package Hint;


public class ContextPrefixFilter implements HintFilterStrategy {


    @Override
    public boolean accepteert(String hintTekst, String context) {
        if (hintTekst == null || context == null) {
            return false;
        }
        String prefix = context + ":";
        return hintTekst.startsWith(prefix);
    }
}
