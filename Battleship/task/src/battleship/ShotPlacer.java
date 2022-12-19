package battleship;

import battleship.coordinates.Coordinates;
import battleship.enums.CellValue;
import battleship.exceptions.NotUpdatableCellValueException;
import battleship.fleet.Fleet;
import battleship.views.GridView;

public class ShotPlacer {

    private final Grid GRID;

    public ShotPlacer(Grid grid) {
        GRID = grid;
    }

    public void placeShot(Coordinates shotCoordinates, Fleet fleet) throws NotUpdatableCellValueException {
        GridView gridView = new GridView(GRID);
        if (GRID.isCellEmpty(shotCoordinates)) {
            GRID.setCellValue(shotCoordinates, CellValue.MISS);
            gridView.printFogged();
            System.out.println("You missed!");
        } else if (GRID.isCellOccupiedByShip(shotCoordinates)) {
            GRID.setCellValue(shotCoordinates, CellValue.HIT);
            gridView.printFogged();
            fleet.shootShip(shotCoordinates);
        }
    }
}
