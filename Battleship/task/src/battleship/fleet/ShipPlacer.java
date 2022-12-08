package battleship.fleet;

import battleship.coordinates.Coordinates;
import battleship.coordinates.ShipCoordinates;
import battleship.coordinates.UnalignedCoordinatesException;
import battleship.coordinates.WrongCoordinatesForShipLengthException;
import battleship.enums.RowName;

import java.util.Collections;
import java.util.List;

public class ShipPlacer {

    public void placeShip(Ship ship, ShipCoordinates shipCoordinates) throws UnalignedCoordinatesException, WrongCoordinatesForShipLengthException {
            testCoordinatesAlignment(shipCoordinates);
            testCoordinatesForShipLength(ship, shipCoordinates);
    }

    private void testCoordinatesForShipLength(Ship ship, ShipCoordinates shipCoordinates) throws WrongCoordinatesForShipLengthException {
        Coordinates firstCoordinates = shipCoordinates.START;
        Coordinates secondCoordinates = shipCoordinates.END;

        List<RowName> rowNames = new java.util.ArrayList<>(List.of(firstCoordinates.ROW, secondCoordinates.ROW));
        List<Integer> columns = new java.util.ArrayList<>(List.of(firstCoordinates.COLUMN, secondCoordinates.COLUMN));

        Collections.sort(rowNames);
        Collections.sort(columns);
        if(((rowNames.get(0).getValue() - rowNames.get(1).getValue()) != ship.LENGTH)
                && ((columns.get(0) - columns.get(1)) != ship.LENGTH)) {
            throw new WrongCoordinatesForShipLengthException(ship, firstCoordinates, secondCoordinates);
        }
    }

    private void testCoordinatesAlignment(ShipCoordinates shipCoordinates) throws UnalignedCoordinatesException {
        Coordinates firstCoordinates = shipCoordinates.START;
        Coordinates secondCoordinates = shipCoordinates.END;

        if (firstCoordinates.COLUMN != secondCoordinates.COLUMN && firstCoordinates.ROW != secondCoordinates.ROW) {
            throw new UnalignedCoordinatesException(firstCoordinates, secondCoordinates);
        }
    }
}
