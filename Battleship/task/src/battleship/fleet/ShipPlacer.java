package battleship.fleet;

import battleship.Grid;
import battleship.NotUpdatableCellValueException;
import battleship.coordinates.Coordinates;
import battleship.coordinates.ShipCoordinates;
import battleship.enums.CellValue;
import battleship.enums.RowName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShipPlacer {
    private final Grid GRID;

    public ShipPlacer(Grid grid) {
        GRID = grid;
    }

    public void placeShip(ShipCoordinates shipCoordinates) throws NotUpdatableCellValueException {
        List<Coordinates> coordinatesList = new ArrayList<>(List.of(shipCoordinates.START, shipCoordinates.END));

        Collections.sort(coordinatesList);

        int cursor = shipCoordinates.ARE_ON_SAME_COLUMN ? coordinatesList.get(1).ROW.getValue() : coordinatesList.get(1).COLUMN;

        for (int j = 0; j < shipCoordinates.SHIP.LENGTH; cursor--, j++) {
            Coordinates coordinates = shipCoordinates.ARE_ON_SAME_COLUMN
                    ? new Coordinates(RowName.getRowName(cursor), coordinatesList.get(1).COLUMN)
                    : new Coordinates(coordinatesList.get(1).ROW, cursor);

            GRID.setCellValue(coordinates, CellValue.SHIP);
        }
    }
}
