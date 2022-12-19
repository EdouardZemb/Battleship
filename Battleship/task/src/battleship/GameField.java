package battleship;

import battleship.coordinates.*;
import battleship.exceptions.ExceptionHandler;
import battleship.exceptions.PrintableException;
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
    private final GameFieldView VIEW;
    private Fleet fleet;

    public GameField(int numberOfColumns, int numberOfRows, InputStream inputStream, PrintStream printStream) {
        NUMBER_OF_COLUMNS = numberOfColumns;
        NUMBER_OF_ROWS = numberOfRows;
        GRID = new Grid(numberOfColumns, numberOfRows);
        INPUT_STREAM = inputStream;
        PRINT_STREAM = printStream;
        VIEW = new GameFieldView(this, inputStream, printStream);
    }

    public void initializedGame(Fleet fleet) {
        this.fleet = fleet;
        placeFleet();
    }

    private void placeFleet() {
        CoordinatesFetcher coordinatesFetcher = new CoordinatesFetcher(INPUT_STREAM, PRINT_STREAM);
        for (Ship ship : this.fleet.SHIPS) {
            coordinatesFetcher.askUserForShipCoordinates(ship);
            while (true) {
                try {
                    ShipCoordinates shipCoordinates = coordinatesFetcher.fetchUserShipCoordinates(ship);
                    new ShipPlacer(GRID).placeShip(shipCoordinates);
                    VIEW.printGrid();
                    break;
                } catch (PrintableException exception) {
                    new ExceptionHandler(INPUT_STREAM, PRINT_STREAM)
                            .handleException(exception);
                }
            }
        }
    }

    public void startsPlayersTurn() {
        PRINT_STREAM.println("The game starts");
        VIEW.printFoggedGrid();
        PRINT_STREAM.println("Take a shot!");
        while (!fleet.isFleetSunk()) {
            CoordinatesFetcher coordinatesFetcher = new CoordinatesFetcher(INPUT_STREAM, PRINT_STREAM);
            while (true) {
                try {
                    Coordinates shotCoordinates = coordinatesFetcher.fetchUserShotCoordinates();
                    new ShotPlacer(GRID).placeShot(shotCoordinates, fleet);
                    VIEW.printGrid();
                    break;
                } catch (PrintableException exception) {
                    new ExceptionHandler(INPUT_STREAM, PRINT_STREAM)
                            .handleException(exception);
                }
            }
        }
        PRINT_STREAM.println("You sank the last ship. You won. Congratulations!");
    }
}
