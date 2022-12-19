package battleship.fleet;

import battleship.coordinates.Coordinates;

import java.util.List;

public class Fleet {
    public final List<Ship> SHIPS;

    public Fleet(List<Ship> ships) {
        SHIPS = ships;
    }

    public void shootShip(Coordinates shotCoordinates) {
        for (Ship ship : SHIPS) {
            ship.shootShip(shotCoordinates);
        }
    }

    public boolean isFleetSunk() {
        for (Ship ship : SHIPS) {
            if (!ship.isSank()) {
                return false;
            }
        }
        return true;
    }
}
