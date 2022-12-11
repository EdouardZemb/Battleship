package battleship;

import battleship.coordinates.UnalignedCoordinatesException;
import battleship.coordinates.WrongCoordinatesForShipLengthException;
import battleship.fleet.*;
import battleship.views.GameFieldView;

import java.util.List;

public class Main {

    public static void main(String[] args) throws WrongCoordinatesForShipLengthException, NotUpdatableCellValueException, UnalignedCoordinatesException, ToCloseToAShipException {
        GameField gameField = new GameField(10, 10, System.in, System.out);
        new GameFieldView(gameField).print();

        Fleet fleet = new Fleet(List.of(new AircraftCarrier(), new Battleship(), new Submarine(), new Cruiser(), new Destroyer()));
        gameField.initializedGame(fleet);
    }
}
