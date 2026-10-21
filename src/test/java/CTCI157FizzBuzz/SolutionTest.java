package CTCI157FizzBuzz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {

    private static String expected(int i) {
        if (i % 15 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        }
        return Integer.toString(i);
    }

    private static String kind(String s) {
        return s.equals("Fizz") || s.equals("Buzz") || s.equals("FizzBuzz") ? s : "number";
    }

    @Test
    @Timeout(20)
    void printsInOrderUsingFourThreads() throws Exception {
        int n = 3000;
        List<String> output = Collections.synchronizedList(new ArrayList<>());
        Map<String, Set<Thread>> threadsByKind = Collections.synchronizedMap(new HashMap<>());
        new Solution.FizzBuzz(n, s -> {
            output.add(s);
            threadsByKind.computeIfAbsent(kind(s), k -> Collections.synchronizedSet(new HashSet<>()))
                    .add(Thread.currentThread());
        }).run();

        List<String> expected = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            expected.add(expected(i));
        }
        assertEquals(expected, output);

        Set<Thread> all = new HashSet<>();
        for (Map.Entry<String, Set<Thread>> e : threadsByKind.entrySet()) {
            assertEquals(1, e.getValue().size(), "Todo \"" + e.getKey() + "\" deve vir da mesma thread");
            all.addAll(e.getValue());
        }
        assertEquals(4, all.size(), "Devem ser 4 threads diferentes");
        assertFalse(all.contains(Thread.currentThread()), "A thread do teste não deve imprimir");
    }

    @Test
    @Timeout(10)
    void smallN() throws Exception {
        List<String> output = Collections.synchronizedList(new ArrayList<>());
        new Solution.FizzBuzz(15, output::add).run();
        assertEquals(List.of("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14",
                "FizzBuzz"), output);
    }
}
