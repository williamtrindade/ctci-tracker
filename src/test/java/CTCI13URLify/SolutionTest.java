package CTCI13URLify;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Cria o buffer com espaço extra suficiente (2 chars extras por espaço) e executa o urlify. */
    private String urlify(String input) {
        int spaces = (int) input.chars().filter(c -> c == ' ').count();
        int finalLength = input.length() + spaces * 2;
        char[] buffer = new char[finalLength];
        for (int i = 0; i < finalLength; i++) {
            buffer[i] = i < input.length() ? input.charAt(i) : ' ';
        }
        solution.urlify(buffer, input.length());
        return new String(buffer, 0, finalLength);
    }

    @Test
    void bookExample() {
        char[] str = "Mr John Smith    ".toCharArray();
        solution.urlify(str, 13);
        assertEquals("Mr%20John%20Smith", new String(str));
    }

    @Test
    void stringWithoutSpacesIsUnchanged() {
        assertEquals("abc", urlify("abc"));
    }

    @Test
    void emptyString() {
        assertEquals("", urlify(""));
    }

    @Test
    void leadingTrailingAndConsecutiveSpaces() {
        assertEquals("%20a%20%20b%20", urlify(" a  b "));
    }

    @Test
    void onlySpaces() {
        assertEquals("%20%20%20", urlify("   "));
    }

    @Test
    void bufferLargerThanNeededKeepsResultAtTheBeginning() {
        char[] str = new char[30];
        "a b".getChars(0, 3, str, 0);
        solution.urlify(str, 3);
        assertEquals("a%20b", new String(str, 0, 5));
    }
}
