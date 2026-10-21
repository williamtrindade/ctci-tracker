package CTCI1622LangtonsAnt;

public enum Orientation {
    UP, RIGHT, DOWN, LEFT;

    public Orientation turnClockwise() {
        return values()[(ordinal() + 1) % 4];
    }

    public Orientation turnCounterClockwise() {
        return values()[(ordinal() + 3) % 4];
    }
}
