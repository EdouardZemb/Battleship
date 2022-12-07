package battleship.views;

import battleship.GameField;

public class GameFieldView {
    public final GameField GAME_FIELD;

    public GameFieldView(GameField gameField) {
        GAME_FIELD = gameField;
    }

    public void print() {
        new GridView(GAME_FIELD.GRID).print();
    }
}
