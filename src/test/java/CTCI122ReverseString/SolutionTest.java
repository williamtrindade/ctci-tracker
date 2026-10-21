package CTCI122ReverseString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void nullTerminated() {
        char[] s = {'a', 'b', 'c', '\0'};
        solution.reverse(s);
        assertArrayEquals(new char[]{'c', 'b', 'a', '\0'}, s);
    }

    @Test
    void bufferAfterTerminatorIsUntouched() {
        char[] s = {'h', 'e', 'l', 'l', 'o', '\0', 'x', 'y'};
        solution.reverse(s);
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h', '\0', 'x', 'y'}, s);
    }

    @Test
    void withoutTerminator() {
        char[] s = "abcd".toCharArray();
        solution.reverse(s);
        assertArrayEquals("dcba".toCharArray(), s);
    }

    @Test
    void edgeCases() {
        char[] empty = {'\0'};
        solution.reverse(empty);
        assertArrayEquals(new char[]{'\0'}, empty);
        char[] single = {'z', '\0'};
        solution.reverse(single);
        assertArrayEquals(new char[]{'z', '\0'}, single);
        assertDoesNotThrow(() -> solution.reverse(null));
        char[] zero = new char[0];
        solution.reverse(zero);
    }
}
