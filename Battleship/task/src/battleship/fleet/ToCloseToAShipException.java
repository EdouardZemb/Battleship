package battleship.fleet;

import battleship.exceptions.ExceptionView;
import battleship.exceptions.PrintableException;

public class ToCloseToAShipException extends PrintableException {
    public ToCloseToAShipException() {
        super(null);
    }

    @Override
    public void print(ExceptionView exceptionView) {
        exceptionView.print("Error! You placed it too close to another one. Try again:");
    }
}
