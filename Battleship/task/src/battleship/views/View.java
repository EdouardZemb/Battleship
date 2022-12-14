package battleship.views;

import java.io.InputStream;
import java.io.PrintStream;

public abstract class View {
    protected final InputStream INPUT_STREAM;
    protected final PrintStream PRINT_STREAM;

    protected View(InputStream inputStream, PrintStream printStream) {
        INPUT_STREAM = inputStream;
        PRINT_STREAM = printStream;
    }

    public void print(String string) {
        PRINT_STREAM.println(string);
    }
}
