package battleship.exceptions;

import battleship.views.View;

import java.io.InputStream;
import java.io.PrintStream;

public class ExceptionView extends View {
    protected ExceptionView(InputStream inputStream, PrintStream printStream) {
        super(inputStream, printStream);
    }

    public void print(String message) {
        PRINT_STREAM.println(message);
    }
}
