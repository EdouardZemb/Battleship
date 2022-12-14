package battleship.exceptions;

import battleship.coordinates.ShipCoordinates;

public abstract class ShipCoordinatedPrintableException extends PrintableException {
    final ShipCoordinates SHIP_COORDINATES;
    public ShipCoordinatedPrintableException(String message, ShipCoordinates shipCoordinates) {
        super(message);
        SHIP_COORDINATES = shipCoordinates;
    }
}
