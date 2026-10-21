package CTCI76Jigsaw;

/** Ordem horária: LEFT -> TOP -> RIGHT -> BOTTOM. */
public enum Orientation {
    LEFT, TOP, RIGHT, BOTTOM;

    public Orientation getOpposite() {
        return switch (this) {
            case LEFT -> RIGHT;
            case RIGHT -> LEFT;
            case TOP -> BOTTOM;
            case BOTTOM -> TOP;
        };
    }
}
