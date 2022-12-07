package battleship.enums;

public enum RowName {
    A(0), B(1), C(2), D(3), E(4), F(5), G(6), H(7), I(8), J(9);

    private final int VALUE;

    RowName(int i) {
        VALUE = i;
    }

    public static RowName getRowName(int i) {
        for (RowName rowName : RowName.values()) {
            if (rowName.getValue() == i) {
                return rowName;
            }
        }
        return null;
    }

    public int getValue() {
        return VALUE;
    }
}
