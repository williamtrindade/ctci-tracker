package CTCI121LastKLines;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private List<String> run(String content, int k) throws IOException {
        return solution.lastKLines(new BufferedReader(new StringReader(content)), k);
    }

    @Test
    void lastLines() throws IOException {
        assertEquals(List.of("c", "d", "e"), run("a\nb\nc\nd\ne\n", 3));
        assertEquals(List.of("e"), run("a\nb\nc\nd\ne", 1));
    }

    @Test
    void fewerLinesThanK() throws IOException {
        assertEquals(List.of("a", "b"), run("a\nb\n", 5));
        assertEquals(List.of(), run("", 3));
    }

    @Test
    void exactlyKLines() throws IOException {
        assertEquals(List.of("x", "y"), run("x\ny", 2));
    }

    @Test
    void bigFile() throws IOException {
        String content = IntStream.range(0, 100_000).mapToObj(Integer::toString).collect(Collectors.joining("\n"));
        List<String> expected = IntStream.range(99_990, 100_000).mapToObj(Integer::toString).toList();
        assertEquals(expected, run(content, 10));
    }
}
