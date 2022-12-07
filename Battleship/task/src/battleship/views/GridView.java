package battleship.views;

import battleship.Grid;
import battleship.Row;

public class GridView {
    public final Grid GRID;

    public GridView(Grid grid) {
        GRID = grid;
    }

    public void print() {
        System.out.print(" ");
        for (int i = 0; i < GRID.NUMBER_OF_COLUMNS; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (Row row : GRID.ROWS) {
            new RowView(row).print();
            System.out.println();
        }
    }
}
