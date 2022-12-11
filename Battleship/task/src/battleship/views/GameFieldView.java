package battleship.views;

import battleship.GameField;
import battleship.View;

import java.io.InputStream;
import java.io.PrintStream;

public class GameFieldView extends View {
    public final GameField GAME_FIELD;

    public GameFieldView(GameField gameField, InputStream inputStream, PrintStream printStream) {
        super(inputStream, printStream);
        GAME_FIELD = gameField;
    }

    public void printGrid() {
        new GridView(GAME_FIELD.GRID).print();
    }
}
