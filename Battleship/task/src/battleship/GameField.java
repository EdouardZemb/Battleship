package battleship;

public class GameField {
    public final int NUMBER_OF_COLUMNS;
    public final int NUMBER_OF_ROWS;
    public final Grid GRID;

    public GameField(int numberOfColumns, int numberOfRows) {
        NUMBER_OF_COLUMNS = numberOfColumns;
        NUMBER_OF_ROWS = numberOfRows;
        GRID = new Grid(numberOfColumns, numberOfRows);
    }
}
