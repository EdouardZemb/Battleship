package battleship.views;

import battleship.Cell;
import battleship.Row;

public class RowView {
    public final Row ROW;

    public RowView(Row row) {
        ROW = row;
    }

    public void print() {
        System.out.print(ROW.name);
        for (Cell cell : ROW.CELLS) {
            System.out.print(' ');
            new CellView(cell).print();
        }
    }

    public void printFogged() {
        System.out.print(ROW.name);
        for (Cell cell : ROW.CELLS) {
            System.out.print(' ');
            new CellView(cell).printFogged();
        }
    }
}
