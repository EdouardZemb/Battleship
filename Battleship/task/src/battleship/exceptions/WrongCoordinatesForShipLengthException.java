package battleship.exceptions;

import battleship.coordinates.ShipCoordinates;

public class WrongCoordinatesForShipLengthException extends ShipCoordinatedPrintableException {

    /**
     * Construct an exception when coordinates doesn't match ship length
     */
    public WrongCoordinatesForShipLengthException(ShipCoordinates shipCoordinates) {
        super("the " +
                shipCoordinates.SHIP.NAME +
                " doesn't fit in between the coordinates " +
                shipCoordinates.START +
                " and " +
                shipCoordinates.END +
                ".",
                shipCoordinates);
    }

    @Override
    public void print(ExceptionView exceptionView) {
        exceptionView.print("Error! Wrong length of the " +
                SHIP_COORDINATES.SHIP.NAME +
                " Try again:");
    }
}
