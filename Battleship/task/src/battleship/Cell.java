package battleship;

import battleship.enums.CellValue;

public class Cell {
    private CellValue value = CellValue.DEFAULT;

    Cell() {}

    @SuppressWarnings("unused")
    Cell(CellValue value) {
        this.value = value;
    }

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) throws NotUpdatableCellValueException {
        if (this.value != CellValue.DEFAULT) {
            throw new NotUpdatableCellValueException();
        }
        this.value = value;
    }
}
