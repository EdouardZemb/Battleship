package battleship;

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

    public void setValue(CellValue value) {
        this.value = value;
    }
}
