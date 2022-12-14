package battleship.views;

import battleship.Grid;
import battleship.Row;

public class GridView {
    public final Grid GRID;

    public GridView(Grid grid) {
        GRID = grid;
    }

    public void print() {
        printColumnNumbers();
        for (Row row : GRID.ROWS) {
            new RowView(row).print();
            System.out.println();
        }
    }

    public void printFogged() {
        printColumnNumbers();
        for (Row row : GRID.ROWS) {
            new RowView(row).printFogged();
            System.out.println();
        }
    }

    private void printColumnNumbers() {
        System.out.print(" ");
        for (int i = 0; i < GRID.NUMBER_OF_COLUMNS; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
    }
}
