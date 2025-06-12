package Test;

import Hint.Hint;
import Hint.HintProvider;

import java.util.Arrays;
import java.util.List;

public class HintProviderStub {

    public static void main(String[] args) {
        String context = "ik ben een hint";

        // Simuleer een stubprovider
        HintProvider stubProvider = new HintProvider() {
            @Override
            public List<Hint> getHintsForContext(String context) {
                return Arrays.asList(
                        new Hint("Stubhint 1 voor: " + context, "info"),
                        new Hint("Stubhint 2 voor: " + context, "warning")
                );
            }
        };

        // Gebruik de stub
        List<Hint> hints = stubProvider.getHintsForContext(context);

        // Toon de resultaten
        for (Hint hint : hints) {
            System.out.println("Hint: " + hint.getTekst() + " | Type: " + hint.getType());
        }
    }
}
