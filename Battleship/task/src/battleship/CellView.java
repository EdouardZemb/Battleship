package battleship;

public class CellView {
    public final Cell CELL;

    public CellView(Cell cell) {
        CELL = cell;
    }

    void print() {
        System.out.print(CELL.getValue());
    }
}
