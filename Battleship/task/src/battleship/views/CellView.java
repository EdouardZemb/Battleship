package battleship.views;

import battleship.Cell;

public class CellView {
    public final Cell CELL;

    public CellView(Cell cell) {
        CELL = cell;
    }

    void print() {
        StringBuilder stringBuilder = new StringBuilder();
        switch (CELL.getValue()) {
            case HIT -> stringBuilder.append('X');
            case MISS -> stringBuilder.append('M');
            case SHIP -> stringBuilder.append('O');
            case DEFAULT -> stringBuilder.append('~');
        }
        System.out.print(stringBuilder);
    }

    public void printFogged() {
        StringBuilder stringBuilder = new StringBuilder();
        switch (CELL.getValue()) {
            case HIT -> stringBuilder.append('X');
            case MISS -> stringBuilder.append('M');
            case SHIP, DEFAULT -> stringBuilder.append('~');
        }
        System.out.print(stringBuilder);
    }
}
