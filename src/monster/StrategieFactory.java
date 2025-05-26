package monster;

public class StrategieFactory {
    public static AanvalsStrategie maakStrategie(String type) {
        return switch (type.toLowerCase()) {
            case "grom" -> new GromStrategie();
            case "spring" -> new SpringStrategie();
            default -> throw new IllegalArgumentException("Onbekende strategie: " + type);
        };
    }
}
