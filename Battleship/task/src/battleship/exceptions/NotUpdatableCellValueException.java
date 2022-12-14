package battleship.exceptions;

public class NotUpdatableCellValueException extends PrintableException {

    /**
     * Construct an exception when a cell isn't updatable
     */
    public NotUpdatableCellValueException(String message) {
        super(message);
    }

    @Override
    public void print(ExceptionView exceptionView) {
        exceptionView.print("Error! Already occupied location! Try again:");
    }
}
