package battleship.coordinates;

import battleship.enums.RowName;

public class Coordinates implements Comparable<Coordinates> {
    public final RowName ROW;
    public final int COLUMN;

    public Coordinates(RowName row, int column) {
        ROW = row;
        COLUMN = column;
    }

    @Override
    public int compareTo(Coordinates coordinates) {
        if (ROW.compareTo(coordinates.ROW) > 0 || (ROW.compareTo(coordinates.ROW) == 0 && COLUMN > coordinates.COLUMN)) {
            return 1;
        }
        return ROW.compareTo(coordinates.ROW) == 0 && COLUMN == coordinates.COLUMN ? 0 : -1;
    }
}
