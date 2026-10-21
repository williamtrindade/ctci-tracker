package CTCI94DuplicateURLs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void partitionIsStableAndInRange() {
        for (int i = 0; i < 1000; i++) {
            String url = "http://site" + i + ".com/page";
            int p = solution.partitionOf(url, 7);
            assertTrue(p >= 0 && p < 7);
            assertEquals(p, solution.partitionOf(new String(url.toCharArray()), 7));
        }
    }

    @Test
    void findsDuplicates() {
        List<String> urls = List.of("http://a.com", "http://b.com", "http://a.com", "http://c.com", "http://b.com",
                "http://a.com");
        assertEquals(Set.of("http://a.com", "http://b.com"), solution.findDuplicates(urls, 3));
        assertTrue(solution.findDuplicates(List.of("http://x.com", "http://y.com"), 4).isEmpty());
    }

    @Test
    void randomUrlsMatchSimpleSet() {
        Random random = new Random(1);
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < 20_000; i++) {
            urls.add("http://site.com/" + random.nextInt(15_000));
        }
        Set<String> seen = new HashSet<>();
        Set<String> expected = new HashSet<>();
        for (String u : urls) {
            if (!seen.add(u)) {
                expected.add(u);
            }
        }
        assertEquals(expected, solution.findDuplicates(urls, 16));
    }
}
