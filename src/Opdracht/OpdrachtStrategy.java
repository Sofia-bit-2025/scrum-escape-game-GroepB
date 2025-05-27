package Opdracht;

/**
 * Interface voor opdrachten -> per kamer verschillend
 * Wordt gebruikt in het Strategy Pattern.
 */
public interface OpdrachtStrategy {
    /**
     * Voert de opdracht uit.
     * @return true als de opdracht succesvol werd uitgevoerd
     */
    boolean voerUit();
}
