package CTCI106SortBigFile;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @TempDir
    Path dir;

    private void check(List<String> lines, int maxLines) throws IOException {
        Path input = dir.resolve("input.txt");
        Path output = dir.resolve("output.txt");
        Files.write(input, lines, StandardCharsets.UTF_8);
        solution.sortFile(input, output, maxLines);
        List<String> expected = new ArrayList<>(lines);
        Collections.sort(expected);
        assertEquals(expected, Files.readAllLines(output, StandardCharsets.UTF_8));
    }

    @Test
    void smallFile() throws IOException {
        check(List.of("pear", "apple", "fig", "banana", "apple"), 2);
    }

    @Test
    void emptyFile() throws IOException {
        check(List.of(), 10);
    }

    @Test
    void manyChunks() throws IOException {
        Random random = new Random(1);
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < 20_000; i++) {
            lines.add(Long.toString(random.nextLong() & Long.MAX_VALUE, 36));
        }
        check(lines, 777);
    }
}
