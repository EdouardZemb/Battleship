package battleship;

import battleship.enums.CellValue;

public class Cell {
    private CellValue value = CellValue.DEFAULT;

    Cell() {}

    public CellValue getValue() {
        return value;
    }

    public void setValue(CellValue value) {
        this.value = value;
    }

    public boolean isOccupied() {
        return value != CellValue.DEFAULT;
    }

    public boolean isEmpty() {
        return value == CellValue.DEFAULT;
    }

    public boolean isOccupiedByShip() {
        return value == CellValue.SHIP;
    }
}
