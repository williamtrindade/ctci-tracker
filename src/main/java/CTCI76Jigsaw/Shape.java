package CTCI76Jigsaw;

public enum Shape {
    INNER, OUTER, FLAT;

    public Shape getOpposite() {
        return switch (this) {
            case INNER -> OUTER;
            case OUTER -> INNER;
            default -> null;
        };
    }
}
