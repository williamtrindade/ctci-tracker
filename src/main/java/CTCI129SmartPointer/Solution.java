package CTCI129SmartPointer;

import java.util.function.Consumer;

public class Solution {

    public static class SmartPointer<T> {
        public SmartPointer(T object, Consumer<T> deleter) {
            // TODO: Implement CTCI 12.9 Smart Pointer
        }

        public SmartPointer<T> copy() {
            throw new UnsupportedOperationException("TODO: CTCI 12.9 Smart Pointer");
        }

        public T get() {
            throw new UnsupportedOperationException("TODO: CTCI 12.9 Smart Pointer");
        }

        public void release() {
            throw new UnsupportedOperationException("TODO: CTCI 12.9 Smart Pointer");
        }

        public int refCount() {
            throw new UnsupportedOperationException("TODO: CTCI 12.9 Smart Pointer");
        }
    }
}
