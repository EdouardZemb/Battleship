package battleship;

public class GameFieldView {
    public final GameField GAME_FIELD;

    GameFieldView(GameField gameField) {
        GAME_FIELD = gameField;
    }

    public void print() {
        new GridView(GAME_FIELD.GRID).print();
    }
}
