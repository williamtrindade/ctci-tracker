package CTCI64AntsOnATriangle;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void triangle() {
        assertEquals(0.75, solution.collisionProbability(3), 1e-12);
    }

    @Test
    void polygons() {
        assertEquals(0.875, solution.collisionProbability(4), 1e-12);
        assertEquals(1 - 1.0 / 512, solution.collisionProbability(10), 1e-12);
    }

    @Test
    void simulationAgreesWithFormula() {
        Random random = new Random(2024);
        for (int n = 3; n <= 6; n++) {
            assertEquals(solution.collisionProbability(n),
                    solution.simulateCollisionProbability(n, 200_000, random), 0.01, "n = " + n);
        }
    }
}
