package CTCI62Basketball;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void probabilities() {
        assertEquals(0.3, solution.probabilityGame1(0.3), 1e-12);
        assertEquals(0.216, solution.probabilityGame2(0.3), 1e-12);
        assertEquals(0.5, solution.probabilityGame2(0.5), 1e-12);
        assertEquals(0.896, solution.probabilityGame2(0.8), 1e-12);
        assertEquals(0.0, solution.probabilityGame2(0.0), 1e-12);
        assertEquals(1.0, solution.probabilityGame2(1.0), 1e-12);
    }

    @Test
    void game2MatchesSimulation() {
        Random random = new Random(1);
        double p = 0.65;
        int wins = 0;
        int trials = 200_000;
        for (int t = 0; t < trials; t++) {
            int made = 0;
            for (int s = 0; s < 3; s++) {
                if (random.nextDouble() < p) {
                    made++;
                }
            }
            if (made >= 2) {
                wins++;
            }
        }
        assertEquals((double) wins / trials, solution.probabilityGame2(p), 0.005);
    }

    @Test
    void bestGame() {
        assertEquals(1, solution.bestGame(0.1));
        assertEquals(1, solution.bestGame(0.49));
        assertEquals(2, solution.bestGame(0.51));
        assertEquals(2, solution.bestGame(0.9));
        assertEquals(0, solution.bestGame(0.0));
        assertEquals(0, solution.bestGame(0.5));
        assertEquals(0, solution.bestGame(1.0));
    }
}
