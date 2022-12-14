package battleship.exceptions;

public class WrongCoordinatesException extends PrintableException {

    /**
     * Construct an exception when coordinates don't match any coordinates on grid
     */
    public WrongCoordinatesException() {
        super(null);
    }

    @Override
    public void print(ExceptionView exceptionView) {
        exceptionView.print("Error! You entered the wrong coordinates! Try again:");
    }
}
