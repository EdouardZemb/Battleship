package battleship;

import battleship.coordinates.CoordinatesFetcher;
import battleship.coordinates.ShipCoordinates;
import battleship.coordinates.UnalignedCoordinatesException;
import battleship.coordinates.WrongCoordinatesForShipLengthException;
import battleship.fleet.Fleet;
import battleship.fleet.Ship;
import battleship.fleet.ShipPlacer;
import battleship.views.GameFieldView;

import java.io.InputStream;
import java.io.PrintStream;

public class GameField {
    public final int NUMBER_OF_COLUMNS;
    public final int NUMBER_OF_ROWS;
    public final Grid GRID;
    private final InputStream INPUT_STREAM;
    private final PrintStream PRINT_STREAM;

    public GameField(int numberOfColumns, int numberOfRows, InputStream inputStream, PrintStream printStream) {
        NUMBER_OF_COLUMNS = numberOfColumns;
        NUMBER_OF_ROWS = numberOfRows;
        GRID = new Grid(numberOfColumns, numberOfRows);
        INPUT_STREAM = inputStream;
        PRINT_STREAM = printStream;
    }

    public void initializedGame(Fleet fleet) {
        placeFleet(fleet);
    }

    private void placeFleet(Fleet fleet) {
        CoordinatesFetcher coordinatesFetcher = new CoordinatesFetcher(INPUT_STREAM, PRINT_STREAM);
        for (Ship ship : fleet.SHIPS) {
            coordinatesFetcher.askUserForShipCoordinates(ship);
            while (true) {
                try {
                    ShipCoordinates shipCoordinates = coordinatesFetcher.fetchUserShipCoordinates(ship);
                    new ShipPlacer(GRID).placeShip(shipCoordinates);
                    new GameFieldView(this).print();
                    break;
                } catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (exception instanceof UnalignedCoordinatesException) {
                        stringBuilder.append("Error! Wrong ship location! Try again:");
                    }
                    if (exception instanceof WrongCoordinatesForShipLengthException) {
                        stringBuilder
                                .append("Error! Wrong length of the ")
                                .append(ship.NAME)
                                .append(" Try again:");
                    }
                    if (exception instanceof NotUpdatableCellValueException) {
                        stringBuilder
                                .append("Error! Already occupied location! Try again:");
                    }
                    PRINT_STREAM.println(stringBuilder);
                }
            }
        }
    }
}
