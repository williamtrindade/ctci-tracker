package CTCI76Jigsaw;

/** Borda de uma peça. Duas bordas se encaixam se têm o mesmo código e formatos opostos (INNER/OUTER). */
public class Edge {
    private final Shape shape;
    private final int code;

    public Edge(Shape shape, int code) {
        this.shape = shape;
        this.code = code;
    }

    public Shape getShape() {
        return shape;
    }

    public int getCode() {
        return code;
    }

    public boolean fitsWith(Edge other) {
        return shape != Shape.FLAT && other.shape == shape.getOpposite() && other.code == code;
    }

    @Override
    public String toString() {
        return shape + "#" + code;
    }
}
