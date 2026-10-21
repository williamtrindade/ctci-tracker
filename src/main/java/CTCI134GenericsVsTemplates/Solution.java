package CTCI134GenericsVsTemplates;

import java.util.List;

public class Solution {

    public static class Box<T> {
        public Box(T value) {
            // TODO: Implement CTCI 13.4 Generics vs. Templates
        }

        public T get() {
            throw new UnsupportedOperationException("TODO: CTCI 13.4 Generics vs. Templates");
        }

        public static int instanceCount() {
            throw new UnsupportedOperationException("TODO: CTCI 13.4 Generics vs. Templates");
        }
    }

    static boolean sameRuntimeClass(Object a, Object b) {
        throw new UnsupportedOperationException("TODO: CTCI 13.4 Generics vs. Templates");
    }

    static <T extends Comparable<T>> T max(List<T> list) {
        throw new UnsupportedOperationException("TODO: CTCI 13.4 Generics vs. Templates");
    }
}
