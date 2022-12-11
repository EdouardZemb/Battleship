package battleship;

import battleship.enums.CellValue;

public class Cell {
    private CellValue value = CellValue.DEFAULT;

    Cell() {}

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) throws NotUpdatableCellValueException {
        if (isOccupied()) {
            throw new NotUpdatableCellValueException();
        }
        this.value = value;
    }

    public boolean isOccupied() {
        return value != CellValue.DEFAULT;
    }
}
