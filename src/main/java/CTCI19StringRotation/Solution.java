package CTCI19StringRotation;

public class Solution {
    boolean isRotation(String s1, String s2) {
        // TODO: Implement CTCI 1.9 String Rotation (use apenas UMA chamada a isSubstring)
        throw new UnsupportedOperationException("TODO: CTCI 1.9 String Rotation");
    }

    /** Já implementado: verifica se {@code small} é substring de {@code big}. */
    boolean isSubstring(String big, String small) {
        isSubstringCalls++;
        return big.contains(small);
    }

    int isSubstringCalls = 0;
}
