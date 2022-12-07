package battleship;

import battleship.views.GameFieldView;

public class Main {

    public static void main(String[] args) {
        GameField gameField = new GameField(10, 10);
        new GameFieldView(gameField).print();
    }
}
