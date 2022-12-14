package battleship.exceptions;

import battleship.coordinates.Coordinates;

public class UnalignedCoordinatesException extends PrintableException {

    /**
     * Construct a checked exception when two couples of coordinates are unaligned
     */
    public UnalignedCoordinatesException(Coordinates firstCoordinates, Coordinates secondCoordinates) {
        super(firstCoordinates + " and " + secondCoordinates + " are unaligned");
    }

    @Override
    public void print(ExceptionView exceptionView) {
        exceptionView.print("Error! Wrong ship location! Try again:");
    }
}
