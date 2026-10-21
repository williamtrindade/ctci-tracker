package CTCI1726SparseSimilarity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static Map<DocPair, Double> brute(Map<Integer, List<Integer>> docs) {
        Map<DocPair, Double> result = new HashMap<>();
        List<Integer> ids = new ArrayList<>(docs.keySet());
        for (int i = 0; i < ids.size(); i++) {
            for (int j = i + 1; j < ids.size(); j++) {
                Set<Integer> a = new HashSet<>(docs.get(ids.get(i)));
                Set<Integer> b = new HashSet<>(docs.get(ids.get(j)));
                Set<Integer> inter = new HashSet<>(a);
                inter.retainAll(b);
                if (!inter.isEmpty()) {
                    Set<Integer> union = new HashSet<>(a);
                    union.addAll(b);
                    int x = Math.min(ids.get(i), ids.get(j));
                    int y = Math.max(ids.get(i), ids.get(j));
                    result.put(new DocPair(x, y), inter.size() / (double) union.size());
                }
            }
        }
        return result;
    }

    private static void assertSimilarities(Map<DocPair, Double> expected, Map<DocPair, Double> actual) {
        assertEquals(expected.keySet(), actual.keySet());
        for (DocPair p : expected.keySet()) {
            assertEquals(expected.get(p), actual.get(p), 1e-12, p.toString());
        }
    }

    @Test
    void bookExample() {
        Map<Integer, List<Integer>> docs = Map.of(
                13, List.of(14, 15, 100, 9, 3),
                16, List.of(32, 1, 9, 3, 5),
                19, List.of(15, 29, 2, 6, 8, 7),
                24, List.of(7, 10));
        assertSimilarities(Map.of(
                new DocPair(13, 19), 0.1,
                new DocPair(13, 16), 0.25,
                new DocPair(19, 24), 0.14285714285714285), solution.computeSimilarities(docs));
    }

    @Test
    void noOverlap() {
        assertEquals(Map.of(), solution.computeSimilarities(Map.of(1, List.of(1, 2), 2, List.of(3, 4))));
    }

    @Test
    @Timeout(10)
    void randomSparseDocuments() {
        Random random = new Random(1726);
        Map<Integer, List<Integer>> docs = new HashMap<>();
        for (int id = 0; id < 300; id++) {
            List<Integer> words = random.ints(0, 5000).distinct().limit(random.nextInt(20) + 1).boxed().toList();
            docs.put(id * 3 + 1, new ArrayList<>(words));
        }
        assertSimilarities(brute(docs), solution.computeSimilarities(docs));
    }
}
