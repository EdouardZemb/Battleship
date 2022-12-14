package battleship.exceptions;

import battleship.interfaces.Printable;

public abstract class PrintableException extends Exception implements Printable {
    public PrintableException(String message) {
        super(message);
    }
}
