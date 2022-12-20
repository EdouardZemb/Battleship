package battleship;

import battleship.fleet.Fleet;

public class Player {
    public final String NAME;
    public final Fleet FLEET;
    public final Grid GRID;
    private Player adversary = null;
    public Player(String name, Fleet fleet, Grid grid) {
        NAME = name;
        FLEET = fleet;
        GRID = grid;
    }

    public Player getAdversary() {
        return adversary;
    }

    public void setAdversary(Player adversary) {
        this.adversary = adversary;
    }
}
