package CTCI1613BisectSquares;

/** Quadrado alinhado aos eixos: canto inferior esquerdo (left, bottom) e lado size. */
public record Square(double left, double bottom, double size) {
    public double right() {
        return left + size;
    }

    public double top() {
        return bottom + size;
    }

    public Point middle() {
        return new Point(left + size / 2, bottom + size / 2);
    }
}
