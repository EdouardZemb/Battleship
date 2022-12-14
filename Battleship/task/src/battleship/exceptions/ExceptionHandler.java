package battleship.exceptions;

import java.io.InputStream;
import java.io.PrintStream;

public class ExceptionHandler {
    private final ExceptionView EXCEPTION_VIEW;
    public ExceptionHandler(InputStream inputStream, PrintStream printStream) {
        EXCEPTION_VIEW = new ExceptionView(inputStream, printStream);
    }

    public void handleException(PrintableException exception) {
        exception.print(EXCEPTION_VIEW);
    }
}