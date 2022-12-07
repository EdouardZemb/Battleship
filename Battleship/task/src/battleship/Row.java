package battleship;

import battleship.enums.CellValue;
import battleship.enums.RowName;

import java.util.ArrayList;
import java.util.List;

public class Row {
    public RowName name;
    public final List<Cell> CELLS;

    Row(int numberOfCells, int rowNumber) {
        name = RowName.getRowName(rowNumber);
        CELLS = new ArrayList<>(numberOfCells);
        for (int i = 0; i < numberOfCells; i++) {
            CELLS.add(i, new Cell());
        }
    }

    public CellValue getCellValue(int column) {
        return CELLS.get(column).getValue();
    }

    public void setCellValue(int column, CellValue value) {
        CELLS.get(column).setValue(value);
    }
}
