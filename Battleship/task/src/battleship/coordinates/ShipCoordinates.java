package battleship.coordinates;

import battleship.enums.RowName;
import battleship.fleet.Ship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShipCoordinates {
    public final Ship SHIP;
    public final Coordinates START;
    public final Coordinates END;
    public final boolean ARE_ON_SAME_COLUMN;
    public final boolean ARE_ONE_SAME_ROW;

    public ShipCoordinates(Ship ship, Coordinates start, Coordinates end) throws WrongCoordinatesForShipLengthException, UnalignedCoordinatesException {
        SHIP = ship;
        START = start;
        END = end;
        testCoordinatesAlignment();
        testCoordinatesForShipLength();
        ARE_ON_SAME_COLUMN = areOnSameColumn();
        ARE_ONE_SAME_ROW = areOnSameROw();
    }

    private boolean areOnSameROw() {
        return START.ROW.compareTo(END.ROW) == 0;
    }

    private boolean areOnSameColumn() {
        return START.COLUMN == END.COLUMN;
    }

    private void testCoordinatesForShipLength() throws WrongCoordinatesForShipLengthException {
        List<RowName> rowNames = new ArrayList<>(List.of(START.ROW, END.ROW));
        List<Integer> columns = new ArrayList<>(List.of(START.COLUMN, END.COLUMN));

        Collections.sort(rowNames);
        Collections.sort(columns);

        if (((rowNames.get(1).getValue() - rowNames.get(0).getValue()) != SHIP.LENGTH - 1)
                && ((columns.get(1) - columns.get(0)) != SHIP.LENGTH - 1)) {
            throw new WrongCoordinatesForShipLengthException(SHIP, START, END);
        }
    }

    private void testCoordinatesAlignment() throws UnalignedCoordinatesException {
        if (START.COLUMN != END.COLUMN && START.ROW != END.ROW) {
            throw new UnalignedCoordinatesException(START, END);
        }
    }
}
