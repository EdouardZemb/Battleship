package battleship;

import battleship.fleet.*;
import battleship.views.GameFieldView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameField gameField = new GameField(10, 10, System.in, System.out);
        new GameFieldView(gameField).print();

        Fleet fleet = new Fleet(List.of(new AircraftCarrier(), new Battleship(), new Cruiser(), new Destroyer(), new Submarine()));
        gameField.initializedGame(fleet);
    }
}
