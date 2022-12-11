package battleship;

import battleship.coordinates.*;
import battleship.fleet.Fleet;
import battleship.fleet.Ship;
import battleship.fleet.ShipPlacer;
import battleship.fleet.ToCloseToAShipException;
import battleship.views.GameFieldView;

import java.io.InputStream;
import java.io.PrintStream;

public class GameField {
    public final int NUMBER_OF_COLUMNS;
    public final int NUMBER_OF_ROWS;
    public final Grid GRID;
    private final InputStream INPUT_STREAM;
    private final PrintStream PRINT_STREAM;
    private final GameFieldView VIEW;

    public GameField(int numberOfColumns, int numberOfRows, InputStream inputStream, PrintStream printStream) {
        NUMBER_OF_COLUMNS = numberOfColumns;
        NUMBER_OF_ROWS = numberOfRows;
        GRID = new Grid(numberOfColumns, numberOfRows);
        INPUT_STREAM = inputStream;
        PRINT_STREAM = printStream;
        VIEW = new GameFieldView(this, inputStream, printStream);
    }

    public void initializedGame(Fleet fleet) throws WrongCoordinatesForShipLengthException, NotUpdatableCellValueException, UnalignedCoordinatesException, ToCloseToAShipException, WroogCoordinatesException {
        placeFleet(fleet);
    }

    private void placeFleet(Fleet fleet) throws WrongCoordinatesForShipLengthException, NotUpdatableCellValueException, UnalignedCoordinatesException, ToCloseToAShipException, WroogCoordinatesException {
        CoordinatesFetcher coordinatesFetcher = new CoordinatesFetcher(INPUT_STREAM, PRINT_STREAM);
        for (Ship ship : fleet.SHIPS) {
            coordinatesFetcher.askUserForShipCoordinates(ship);
            while (true) {
                try {
                    ShipCoordinates shipCoordinates = coordinatesFetcher.fetchUserShipCoordinates(ship);
                    new ShipPlacer(GRID).placeShip(shipCoordinates);
                    VIEW.printGrid();
                    break;
                } catch (Exception exception) {
                    StringBuilder stringBuilder = new StringBuilder();
                    if (exception instanceof WroogCoordinatesException) {
                        stringBuilder
                                .append("Error! You entered the wrong coordinates! Try again:");
                    } else if (exception instanceof UnalignedCoordinatesException) {
                        stringBuilder.append("Error! Wrong ship location! Try again:");
                    } else if (exception instanceof WrongCoordinatesForShipLengthException) {
                        stringBuilder
                                .append("Error! Wrong length of the ")
                                .append(ship.NAME)
                                .append(" Try again:");
                    } else if (exception instanceof NotUpdatableCellValueException) {
                        stringBuilder
                                .append("Error! Already occupied location! Try again:");
                    } else if (exception instanceof ToCloseToAShipException) {
                        stringBuilder
                                .append("Error! You placed it too close to another one. Try again:");
                    } else {
                        throw exception;
                    }

                    PRINT_STREAM.println(stringBuilder);
                }
            }
        }
    }

    public void startsPlayersTurn() throws WroogCoordinatesException, NotUpdatableCellValueException {
        PRINT_STREAM.println("The game starts");
        VIEW.printGrid();
        PRINT_STREAM.println("Take a shot!");
        CoordinatesFetcher coordinatesFetcher = new CoordinatesFetcher(INPUT_STREAM, PRINT_STREAM);
        while (true) {
            try {
                Coordinates shotCoordinates = coordinatesFetcher.fetchUserShotCoordinates();
                new ShotPlacer(GRID).placeShot(shotCoordinates);
                VIEW.printGrid();
                break;
            } catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                if (exception instanceof WroogCoordinatesException) {
                    stringBuilder
                            .append("Error! You entered the wrong coordinates! Try again:");
                } else {
                    throw exception;
                }
                PRINT_STREAM.println(stringBuilder);
            }
        }
    }
}
