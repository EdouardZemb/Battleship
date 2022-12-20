package battleship;

import battleship.fleet.*;
import battleship.views.GameFieldView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Player 1", new Fleet(List.of(new AircraftCarrier(), new Battleship(), new Submarine(), new Cruiser(), new Destroyer())), new Grid(10, 10));
        Player player2 = new Player("Player 2", new Fleet(List.of(new AircraftCarrier(), new Battleship(), new Submarine(), new Cruiser(), new Destroyer())), new Grid(10, 10));
        player1.setAdversary(player2);
        player2.setAdversary(player1);
        GameField gameField = new GameField(10, 10, System.in, System.out, player1, player2);

        new GameFieldView(gameField, System.in, System.out).printGrid();

        gameField.initializedGame();
        gameField.startsGame();
    }
}
