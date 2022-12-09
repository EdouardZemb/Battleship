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

    public void setCellValue(Coordinates coordinates, CellValue value) throws NotUpdatableCellValueException {
        ROWS.get(coordinates.ROW.getValue()).setCellValue(coordinates.COLUMN, value);
    }
}
