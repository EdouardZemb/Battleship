package battleship;

import battleship.coordinates.Coordinates;
import battleship.enums.CellValue;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    public final int NUMBER_OF_COLUMNS;
    public final List<Row> ROWS;

    public Grid(int numberOfColumns, int numberOfRows) {
        NUMBER_OF_COLUMNS = numberOfColumns;
        ROWS = new ArrayList<>(numberOfRows);
        for (int i = 0; i < numberOfRows; i++) {
            ROWS.add(i, new Row(NUMBER_OF_COLUMNS, i));
        }
    }

    public void setCellValue(Coordinates coordinates, CellValue value) {
        ROWS.get(coordinates.ROW.getValue()).setCellValue(coordinates.COLUMN, value);
    }

    public List<Cell> getAdjacentCells(Coordinates coordinates) {
        List<Cell> adjacentCells = new ArrayList<>();
        int coordinatesRowNameValue = coordinates.ROW.getValue();
        int coordinatesColumn = coordinates.COLUMN;

        if (!coordinates.ROW.isOnTop()) {
            adjacentCells.add(ROWS.get(coordinatesRowNameValue - 1).CELLS.get(coordinatesColumn));
        }
        if (!coordinates.ROW.isOnBottom()) {
            adjacentCells.add(ROWS.get(coordinatesRowNameValue + 1).CELLS.get(coordinatesColumn));
        }
        if (coordinates.COLUMN != 0) {
            adjacentCells.add(ROWS.get(coordinatesRowNameValue).CELLS.get(coordinatesColumn - 1));
        }
        if (coordinates.COLUMN != NUMBER_OF_COLUMNS - 1) {
            adjacentCells.add(ROWS.get(coordinatesRowNameValue).CELLS.get(coordinatesColumn + 1));
        }
        return adjacentCells;
    }

    public boolean isCellEmpty(Coordinates shotCoordinates) {
        return ROWS.get(shotCoordinates.ROW.getValue()).CELLS.get(shotCoordinates.COLUMN).isEmpty();
    }

    public boolean isCellOccupiedByShip(Coordinates shotCoordinates) {
        return ROWS.get(shotCoordinates.ROW.getValue()).CELLS.get(shotCoordinates.COLUMN).isOccupiedByShip();
    }
}
