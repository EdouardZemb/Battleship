package battleship.fleet;

public abstract class Ship {
    public final int LENGTH;
    public final String NAME;
    protected Ship(int length, String name) {
        LENGTH = length;
        NAME = name;
    }
}
