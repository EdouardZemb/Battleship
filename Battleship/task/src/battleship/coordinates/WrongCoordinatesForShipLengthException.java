package battleship.coordinates;

import battleship.fleet.Ship;

public class WrongCoordinatesForShipLengthException extends Exception {
    /**
     * Construct an exception when coordinates doesn't match ship length
     */
    public WrongCoordinatesForShipLengthException(Ship ship, Coordinates firstCoordinates, Coordinates secondCoordinates) {
        super("the " + ship.NAME + " doesn't fit in between the coordinates " + firstCoordinates +" and " + secondCoordinates + ".");
    }
}
