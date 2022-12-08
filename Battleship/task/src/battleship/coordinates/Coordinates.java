package battleship.coordinates;

import battleship.enums.RowName;

public class Coordinates {
    public final RowName ROW;
    public final int COLUMN;

    public Coordinates(RowName row, int column) {
        ROW = row;
        COLUMN = column;
    }
}
