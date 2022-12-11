package battleship;

import battleship.coordinates.Coordinates;
import battleship.enums.CellValue;

public class ShotPlacer {

    private final Grid GRID;

    public ShotPlacer(Grid grid) {
        GRID = grid;
    }

    public void placeShot(Coordinates shotCoordinates) throws NotUpdatableCellValueException {
        if (GRID.isCellEmpty(shotCoordinates)) {
            GRID.setCellValue(shotCoordinates, CellValue.MISS);
            System.out.println("You missed!");
        } else if (GRID.isCellOccupiedByShip(shotCoordinates)) {
            GRID.setCellValue(shotCoordinates, CellValue.HIT);
            System.out.println("You hit a ship!");
        }
    }
}
