package battleship;

import battleship.coordinates.*;
import battleship.exceptions.ExceptionHandler;
import battleship.exceptions.PrintableException;
import battleship.fleet.*;
import battleship.views.GridView;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class GameField {
    public final int NUMBER_OF_COLUMNS;
    public final int NUMBER_OF_ROWS;
    public final Grid GRID;
    private final InputStream INPUT_STREAM;
    private final PrintStream PRINT_STREAM;
    private final Player PLAYER_1;
    private final Player PLAYER_2;

    public GameField(int numberOfColumns, int numberOfRows, InputStream inputStream, PrintStream printStream, Player player1, Player player2) {
        NUMBER_OF_COLUMNS = numberOfColumns;
        NUMBER_OF_ROWS = numberOfRows;
        PLAYER_1 = player1;
        PLAYER_2 = player2;
        GRID = new Grid(numberOfColumns, numberOfRows);
        INPUT_STREAM = inputStream;
        PRINT_STREAM = printStream;
    }

    public void initializedGame() {
        List<Player> players = List.of(PLAYER_1, PLAYER_2);
        for (Player player : players) {
            PRINT_STREAM.println(player.NAME + ", place your ships on the game field");
            placeFleet(player);
            passToTheNextPlayer();
        }
    }

    private void passToTheNextPlayer() {
        PRINT_STREAM.println("Press Enter and pass the move to another player");
        new Scanner(INPUT_STREAM).nextLine();
    }

    private void placeFleet(Player player) {
        CoordinatesFetcher coordinatesFetcher = new CoordinatesFetcher(INPUT_STREAM, PRINT_STREAM);
        for (Ship ship : player.FLEET.SHIPS) {
            coordinatesFetcher.askUserForShipCoordinates(ship);
            while (true) {
                try {
                    ShipCoordinates shipCoordinates = coordinatesFetcher.fetchUserShipCoordinates(ship);
                    new ShipPlacer(player.GRID).placeShip(shipCoordinates);
                    new GridView(player.GRID).print();
                    break;
                } catch (PrintableException exception) {
                    new ExceptionHandler(INPUT_STREAM, PRINT_STREAM)
                            .handleException(exception);
                }
            }
        }
    }

    public void startsGame() {
        PRINT_STREAM.println("The game starts");
        startsPlayersTurn(PLAYER_1);
    }

    public void startsPlayersTurn(Player player) {
        new GridView(player.getAdversary().GRID).printFogged();
        PRINT_STREAM.println("---------------------");
        new GridView(player.GRID).print();
        PRINT_STREAM.println(player.NAME + ", it's your turn:");
        CoordinatesFetcher coordinatesFetcher = new CoordinatesFetcher(INPUT_STREAM, PRINT_STREAM);
        while (true) {
            try {
                Coordinates shotCoordinates = coordinatesFetcher.fetchUserShotCoordinates();
                new ShotPlacer(player.getAdversary().GRID).placeShot(shotCoordinates, player.getAdversary().FLEET);
                break;
            } catch (PrintableException exception) {
                new ExceptionHandler(INPUT_STREAM, PRINT_STREAM)
                        .handleException(exception);
            }
        }
        if (player.getAdversary().FLEET.isFleetSunk()) {
            PRINT_STREAM.println("You sank the last ship." + player.NAME + " won. Congratulations!");
        } else {
            passToTheNextPlayer();
            startsPlayersTurn(player.getAdversary());
        }
    }
}
