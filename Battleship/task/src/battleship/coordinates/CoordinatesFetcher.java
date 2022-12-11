package battleship.coordinates;

import battleship.fleet.Ship;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoordinatesFetcher {
    private final InputStream INPUT_STREAM;
    private final PrintStream PRINT_STREAM;

    public CoordinatesFetcher(InputStream inputStream, PrintStream printStream) {
        INPUT_STREAM = inputStream;
        PRINT_STREAM = printStream;
    }

    public Coordinates fetchUserShotCoordinates() throws WroogCoordinatesException {
        Scanner scanner = new Scanner(INPUT_STREAM);
        return new Coordinates(scanner.nextLine());
    }

    public ShipCoordinates fetchUserShipCoordinates(Ship ship) throws WrongCoordinatesForShipLengthException, UnalignedCoordinatesException, WroogCoordinatesException {
        List<Coordinates> coordinatesList = new ArrayList<>();

        Scanner scanner = new Scanner(INPUT_STREAM);
        String[] inputs = scanner.nextLine().split(" ");

        for (String input : inputs) {
            coordinatesList.add(new Coordinates(input));
        }

        return new ShipCoordinates(ship, coordinatesList.get(0), coordinatesList.get(1));
    }

    public void askUserForShipCoordinates(Ship ship) {
        PRINT_STREAM.println("Enter the coordinates of the " + ship.NAME + " ("+ ship.LENGTH +" cells):");
    }
}
