package CTCI1614BestLine;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int countOnLine(GraphPoint a, GraphPoint b, GraphPoint[] points) {
        int count = 0;
        for (GraphPoint p : points) {
            long cross = (long) (b.x() - a.x()) * (p.y() - a.y()) - (long) (b.y() - a.y()) * (p.x() - a.x());
            if (cross == 0) {
                count++;
            }
        }
        return count;
    }

    private static int bestPossible(GraphPoint[] points) {
        int best = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                best = Math.max(best, countOnLine(points[i], points[j], points));
            }
        }
        return best;
    }

    private void check(GraphPoint[] points) {
        GraphPoint[] line = solution.findBestLine(points);
        Set<GraphPoint> input = Set.of(points);
        assertTrue(input.contains(line[0]) && input.contains(line[1]), "Os dois pontos devem ser da entrada");
        assertNotEquals(line[0], line[1]);
        assertEquals(bestPossible(points), countOnLine(line[0], line[1], points));
    }

    @Test
    void examples() {
        check(new GraphPoint[]{new GraphPoint(0, 0), new GraphPoint(1, 1), new GraphPoint(2, 2), new GraphPoint(3, 4),
                new GraphPoint(5, 1)});
        check(new GraphPoint[]{new GraphPoint(1, 0), new GraphPoint(1, 5), new GraphPoint(1, -3), new GraphPoint(2, 2)});
        check(new GraphPoint[]{new GraphPoint(0, 0), new GraphPoint(7, 3)});
    }

    @Test
    void randomPoints() {
        Random random = new Random(14);
        for (int t = 0; t < 100; t++) {
            Set<GraphPoint> set = new HashSet<>();
            while (set.size() < 2 + random.nextInt(25)) {
                set.add(new GraphPoint(random.nextInt(9) - 4, random.nextInt(9) - 4));
            }
            List<GraphPoint> list = new ArrayList<>(set);
            check(list.toArray(new GraphPoint[0]));
        }
    }
}
