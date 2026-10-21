package CTCI175LettersAndNumbers;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int bruteLength(char[] a) {
        int best = 0;
        for (int i = 0; i < a.length; i++) {
            int balance = 0;
            for (int j = i; j < a.length; j++) {
                balance += Character.isLetter(a[j]) ? 1 : -1;
                if (balance == 0) {
                    best = Math.max(best, j - i + 1);
                }
            }
        }
        return best;
    }

    private void check(String input) {
        char[] array = input.toCharArray();
        char[] result = solution.findLongestSubarray(array);
        assertEquals(bruteLength(array), result.length, "Tamanho do maior subarray para " + input);
        String r = new String(result);
        assertTrue(input.contains(r), "Deve ser um subarray contíguo: " + r);
        long letters = r.chars().filter(Character::isLetter).count();
        assertEquals(result.length / 2.0, letters, "Letras e números devem ser iguais em " + r);
    }

    @Test
    void examples() {
        check("aaaa11a11aa1aa1aaaaa");
        check("a1");
        check("ab12");
        check("aaa");
        check("");
        check("1a1a1a1aa");
    }

    @Test
    void randomArrays() {
        Random random = new Random(175);
        for (int t = 0; t < 500; t++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < random.nextInt(40); i++) {
                sb.append(random.nextBoolean() ? (char) ('a' + random.nextInt(26)) : (char) ('0' + random.nextInt(10)));
            }
            check(sb.toString());
        }
    }
}
