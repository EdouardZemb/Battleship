package battleship.fleet;

import battleship.coordinates.Coordinates;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship {
    public final int LENGTH;
    public final String NAME;
    public List<Coordinates> coordinates = new ArrayList<>();
    private int lives;

    protected Ship(int length, String name) {
        LENGTH = length;
        NAME = name;
        lives = LENGTH;
    }

    public boolean isSank() {
        return lives == 0;
    }

    public void shootShip(Coordinates shotCoordinates) {
        if (coordinates.contains(shotCoordinates)) {
            lives--;
            if (isSank()) {
                System.out.println("You sank a ship");
            } else {
                System.out.println("You hit a ship");
            }
        }
    }
}
