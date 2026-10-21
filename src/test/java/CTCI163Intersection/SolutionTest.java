package CTCI163Intersection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Point p(double x, double y) {
        return new Point(x, y);
    }

    /** O ponto está no segmento (a, b)? */
    private static boolean onSegment(Point a, Point b, Point q) {
        double cross = (b.x() - a.x()) * (q.y() - a.y()) - (b.y() - a.y()) * (q.x() - a.x());
        boolean inBox = q.x() >= Math.min(a.x(), b.x()) - 1e-7 && q.x() <= Math.max(a.x(), b.x()) + 1e-7
                && q.y() >= Math.min(a.y(), b.y()) - 1e-7 && q.y() <= Math.max(a.y(), b.y()) + 1e-7;
        return Math.abs(cross) < 1e-6 && inBox;
    }

    private void assertIntersection(Point s1, Point e1, Point s2, Point e2) {
        Point result = solution.intersection(s1, e1, s2, e2);
        assertNotNull(result, "Os segmentos se intersectam");
        assertTrue(onSegment(s1, e1, result) && onSegment(s2, e2, result), "Ponto fora dos segmentos: " + result);
    }

    @Test
    void crossingSegments() {
        Point r = solution.intersection(p(0, 0), p(4, 4), p(0, 4), p(4, 0));
        assertEquals(2, r.x(), 1e-9);
        assertEquals(2, r.y(), 1e-9);
        assertIntersection(p(4, 4), p(0, 0), p(4, 0), p(0, 4)); // pontos em ordem invertida
    }

    @Test
    void touchingAtEndpoint() {
        assertIntersection(p(0, 0), p(2, 2), p(2, 2), p(5, 0));
    }

    @Test
    void noIntersection() {
        assertNull(solution.intersection(p(0, 0), p(1, 1), p(2, 0), p(3, -1)));     // retas se cruzam fora
        assertNull(solution.intersection(p(0, 0), p(4, 0), p(0, 1), p(4, 1)));      // paralelas
        assertNull(solution.intersection(p(0, 0), p(1, 1), p(2, 2), p(3, 3)));      // colineares sem sobreposição
    }

    @Test
    void collinearOverlap() {
        assertIntersection(p(0, 0), p(3, 3), p(2, 2), p(5, 5));
        assertIntersection(p(0, 0), p(10, 0), p(2, 0), p(3, 0));
    }

    @Test
    void verticalSegments() {
        assertIntersection(p(1, -5), p(1, 5), p(-3, 0), p(3, 2));
        assertNull(solution.intersection(p(1, -5), p(1, 5), p(2, 0), p(3, 2)));
        assertIntersection(p(0, 0), p(0, 4), p(0, 3), p(0, 9));
        assertNull(solution.intersection(p(0, 0), p(0, 4), p(1, 0), p(1, 4)));
    }
}
