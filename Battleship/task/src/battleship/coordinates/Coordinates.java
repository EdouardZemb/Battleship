package battleship.coordinates;

import battleship.Cell;
import battleship.Grid;
import battleship.enums.RowName;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Coordinates implements Comparable<Coordinates> {
    public final RowName ROW;
    public final int COLUMN;

    public Coordinates(RowName row, int column) {
        ROW = row;
        COLUMN = column;
    }

    public Coordinates(String coordinates) throws WroogCoordinatesException {
        Pattern pattern = Pattern.compile("^[A-J]([1-9]|10)$");
        Matcher matcher = pattern.matcher(coordinates);

        if (!matcher.find()) {
            throw new WroogCoordinatesException();
        }

        pattern = Pattern.compile("[A-J]");
        matcher = pattern.matcher(coordinates);

        if (!matcher.find()) {
            throw new WroogCoordinatesException();
        }

        ROW = RowName.valueOf(matcher.group(0));

        pattern = Pattern.compile("(?<=[A-J])([1-9]|10)\\b");
        matcher = pattern.matcher(coordinates);

        if (!matcher.find()) {
            throw new WroogCoordinatesException();
        }

        COLUMN = Integer.parseInt(matcher.group(0)) - 1;
    }

    @Override
    public int compareTo(Coordinates coordinates) {
        if (ROW.compareTo(coordinates.ROW) > 0 || (ROW.compareTo(coordinates.ROW) == 0 && COLUMN > coordinates.COLUMN)) {
            return 1;
        }
        return ROW.compareTo(coordinates.ROW) == 0 && COLUMN == coordinates.COLUMN ? 0 : -1;
    }

    public boolean isNextToAShip(Grid grid) {
        List<Cell> adjacentCells = grid.getAdjacentCells(this);

        for (Cell adjacentCell : adjacentCells) {
            if (adjacentCell.isOccupied()) {
                return true;
            }
        }

        return false;
    }
}
