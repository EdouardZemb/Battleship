package battleship;

import battleship.fleet.*;
import battleship.views.GameFieldView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameField gameField = new GameField(10, 10, System.in, System.out);
        new GameFieldView(gameField, System.in, System.out).printGrid();

        Fleet fleet = new Fleet(List.of(new AircraftCarrier(), new Battleship(), new Submarine(), new Cruiser(), new Destroyer()));
        gameField.initializedGame(fleet);
        gameField.startsPlayersTurn();
    }
}
