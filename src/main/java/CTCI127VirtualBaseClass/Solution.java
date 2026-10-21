package CTCI127VirtualBaseClass;

import java.util.List;

public class Solution {

    public static class Base implements AutoCloseable {
        public Base(List<String> log) {
            // TODO: Implement CTCI 12.7 Virtual Base Class
        }

        @Override
        public void close() {
            throw new UnsupportedOperationException("TODO: CTCI 12.7 Virtual Base Class");
        }
    }

    public static class Derived extends Base {
        public Derived(List<String> log) {
            super(log);
            // TODO
        }
    }
}
