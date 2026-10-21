package CTCI67TheApocalypse;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void everyFamilyHasExactlyOneGirl() {
        Random random = new Random(1);
        for (int i = 0; i < 1000; i++) {
            int[] family = solution.runOneFamily(random);
            assertEquals(1, family[0]);
            assertTrue(family[1] >= 0);
        }
    }

    @Test
    void familyStopsAtTheFirstGirl() {
        // Random "falso": menino, menino, menina, ...
        Random fake = new Random() {
            private int calls = 0;

            @Override
            public boolean nextBoolean() {
                return ++calls % 3 == 0;
            }
        };
        int[] family = solution.runOneFamily(fake);
        assertEquals(1, family[0]);
        assertEquals(2, family[1]);
    }

    @Test
    void ratioIsHalf() {
        assertEquals(0.5, solution.runNFamilies(200_000, new Random(42)), 0.01);
    }
}
