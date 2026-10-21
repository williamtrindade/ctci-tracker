package CTCI1713ReSpace;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Mínimo de caracteres não reconhecidos (DP independente para o teste). */
    private static int minInvalid(Set<String> dict, String s) {
        int n = s.length();
        int[] best = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            best[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j <= n; j++) {
                String w = s.substring(i, j);
                int cost = (dict.contains(w) ? 0 : w.length()) + best[j];
                best[i] = Math.min(best[i], cost);
            }
        }
        return best[0];
    }

    private void check(Set<String> dict, String sentence) {
        String result = solution.bestSplit(dict, sentence);
        assertEquals(sentence, result.replace(" ", ""), "Juntando as palavras deve dar a frase original");
        assertEquals(result.trim(), result);
        int invalid = 0;
        if (!result.isEmpty()) {
            for (String w : result.split(" ")) {
                if (!dict.contains(w)) {
                    invalid += w.length();
                }
            }
        }
        assertEquals(minInvalid(dict, sentence), invalid, "Caracteres não reconhecidos em: " + result);
    }

    private final Set<String> dictionary = Set.of("looked", "just", "like", "her", "brother", "i", "reset", "the",
            "computer", "it", "still", "didnt", "boot", "look", "ed", "a", "an", "and");

    @Test
    void bookExample() {
        // "jess looked just like tim her brother" -> 7 não reconhecidos ("jess" e "tim").
        // Outras divisões com os mesmos 7 (ex.: "j e s s ...") também são aceitas.
        Set<String> bookDictionary = Set.of("looked", "just", "like", "her", "brother");
        check(bookDictionary, "jesslookedjustliketimherbrother");
        assertEquals(7, minInvalid(bookDictionary, "jesslookedjustliketimherbrother"));
        check(dictionary, "jesslookedjustliketimherbrother"); // com "i" no dicionário: só 6 ("jess", "t", "m")
    }

    @Test
    void allRecognized() {
        check(dictionary, "iresetthecomputeritstilldidntboot");
    }

    @Test
    void edgeCases() {
        assertEquals("", solution.bestSplit(dictionary, ""));
        check(dictionary, "xyz");
        check(dictionary, "a");
    }

    @Test
    @Timeout(5)
    void longSentence() {
        String sentence = "iresetthecomputeritstilldidntboot".repeat(15) + "zzz" + "jesslookedjustliketimherbrother".repeat(10);
        check(dictionary, sentence);
    }
}
