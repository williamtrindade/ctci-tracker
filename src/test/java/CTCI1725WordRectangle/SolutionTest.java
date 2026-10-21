package CTCI1725WordRectangle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static void assertValid(List<String> rows, Set<String> dict) {
        assertTrue(!rows.isEmpty());
        int w = rows.get(0).length();
        for (String row : rows) {
            assertEquals(w, row.length(), "Linhas com o mesmo tamanho");
            assertTrue(dict.contains(row), "Linha fora da lista: " + row);
        }
        for (int c = 0; c < w; c++) {
            StringBuilder col = new StringBuilder();
            for (String row : rows) {
                col.append(row.charAt(c));
            }
            assertTrue(dict.contains(col.toString()), "Coluna fora da lista: " + col);
        }
    }

    @Test
    void wordSquare() {
        // BAT / ARE / TEA: as colunas também são BAT, ARE, TEA
        String[] words = {"bat", "are", "tea", "ab", "cd", "ac", "bd", "x"};
        List<String> rows = solution.maxRectangle(words);
        assertValid(rows, Set.of(words));
        assertEquals(9, rows.size() * rows.get(0).length());
    }

    @Test
    void twoByTwo() {
        String[] words = {"ab", "cd", "ac", "bd"};
        List<String> rows = solution.maxRectangle(words);
        assertValid(rows, Set.of(words));
        assertEquals(4, rows.size() * rows.get(0).length());
    }

    @Test
    void nonSquareRectangle() {
        // 2 linhas de 3 letras: "car" / "ate" -> colunas "ca", "at", "re"
        String[] words = {"car", "ate", "ca", "at", "re"};
        List<String> rows = solution.maxRectangle(words);
        assertValid(rows, Set.of(words));
        assertEquals(6, rows.size() * rows.get(0).length());
    }

    @Test
    void smallCases() {
        assertEquals(List.of("a"), solution.maxRectangle(new String[]{"a"}));
        assertTrue(solution.maxRectangle(new String[]{"ab"}).isEmpty());
        assertTrue(solution.maxRectangle(new String[]{}).isEmpty());
    }

    @Test
    @Timeout(10)
    void biggerDictionary() {
        String[] words = {"sator", "arepo", "tenet", "opera", "rotas", "stone", "tones", "notes", "onset", "seton",
                "art", "rat", "tar", "a", "at", "ta"};
        List<String> rows = solution.maxRectangle(words);
        assertValid(rows, Set.of(words));
        assertEquals(25, rows.size() * rows.get(0).length(), "Quadrado SATOR (5x5)");
    }
}
