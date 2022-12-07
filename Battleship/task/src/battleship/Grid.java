package battleship;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    public final int NUMBER_OF_COLUMNS;
    public final List<Row> ROWS;

    public Grid(int numberOfColumns, int numberOfRows) {
        NUMBER_OF_COLUMNS = numberOfColumns;
        ROWS = new ArrayList<>(numberOfRows);
        for (int i = 0; i < numberOfRows; i++) {
            ROWS.add(i, new Row(NUMBER_OF_COLUMNS, i));
        }
    }

    @SuppressWarnings("unused")
    public char getCellValue(RowName row, int column) {
        return ROWS.get(row.getValue()).getCellValue(column);
    }

    @SuppressWarnings("unused")
    public void setCellValue(int row, int column, char value) {
        ROWS.get(row).setCellValue(column, value);
    }
}
