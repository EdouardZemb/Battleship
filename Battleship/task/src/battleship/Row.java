package battleship;

import java.util.ArrayList;
import java.util.List;

public class Row {
    public RowName name;
    public final List<Cell> CELLS;

    Row(int numberOfCells, int numberOfRow) {
        name = RowName.getRowName(numberOfRow);
        CELLS = new ArrayList<>(numberOfCells);
        for (int i = 0; i < numberOfCells; i++) {
            CELLS.add(i, new Cell());
        }
    }

    public char getCellValue(int column) {
        return CELLS.get(column).getValue();
    }

    public void setCellValue(int column, char value) {
        CELLS.get(column).setValue(value);
    }
}
