package CTCI1613BisectSquares;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean onLine(Line line, Point p) {
        double cross = (line.end().x() - line.start().x()) * (p.y() - line.start().y())
                - (line.end().y() - line.start().y()) * (p.x() - line.start().x());
        return Math.abs(cross) < 1e-6;
    }

    private static boolean onBoundary(Square s, Point p) {
        double e = 1e-6;
        boolean insideX = p.x() >= s.left() - e && p.x() <= s.right() + e;
        boolean insideY = p.y() >= s.bottom() - e && p.y() <= s.top() + e;
        boolean onVertical = Math.abs(p.x() - s.left()) < e || Math.abs(p.x() - s.right()) < e;
        boolean onHorizontal = Math.abs(p.y() - s.bottom()) < e || Math.abs(p.y() - s.top()) < e;
        return insideX && insideY && (onVertical || onHorizontal);
    }

    private void check(Square s1, Square s2) {
        Line line = solution.cut(s1, s2);
        assertTrue(Math.hypot(line.end().x() - line.start().x(), line.end().y() - line.start().y()) > 1e-9,
                "Os extremos devem ser distintos");
        assertTrue(onLine(line, s1.middle()), "A reta deve passar pelo centro do quadrado 1");
        assertTrue(onLine(line, s2.middle()), "A reta deve passar pelo centro do quadrado 2");
        for (Point end : new Point[]{line.start(), line.end()}) {
            assertTrue(onBoundary(s1, end) || onBoundary(s2, end), "Extremo fora das bordas: " + end);
        }
    }

    @Test
    void examples() {
        check(new Square(0, 0, 2), new Square(4, 4, 2));    // diagonal
        check(new Square(0, 0, 2), new Square(5, 0, 2));    // horizontal
        check(new Square(0, 0, 2), new Square(0, 6, 4));    // vertical, tamanhos diferentes
        check(new Square(0, 0, 4), new Square(1, 1, 2));    // mesmo centro
        check(new Square(0, 0, 10), new Square(2, 1, 1));   // um dentro do outro
    }

    @Test
    void randomSquares() {
        Random random = new Random(13);
        for (int t = 0; t < 500; t++) {
            check(new Square(random.nextInt(20), random.nextInt(20), random.nextInt(5) + 1),
                    new Square(random.nextInt(20), random.nextInt(20), random.nextInt(5) + 1));
        }
    }
}
