package battleship.coordinates;

/**
 *
 */
public class UnalignedCoordinatesException extends Exception {
    /**
     * Construct a checked exception when two couples of coordinates are unaligned
     */
    public UnalignedCoordinatesException(Coordinates firstCoordinates, Coordinates secondCoordinates) {
        super(firstCoordinates + " and " + secondCoordinates + " are unaligned");
    }
}
