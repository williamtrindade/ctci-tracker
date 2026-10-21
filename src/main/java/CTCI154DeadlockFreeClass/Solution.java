package CTCI154DeadlockFreeClass;

import java.util.concurrent.locks.Lock;

public class Solution {

    public static class LockFactory {
        public LockFactory(int resourceCount) {
            // TODO: Implement CTCI 15.4 Deadlock-Free Class
        }

        public boolean declare(int ownerId, int[] resourcesInOrder) {
            throw new UnsupportedOperationException("TODO: CTCI 15.4 Deadlock-Free Class");
        }

        public Lock getLock(int ownerId, int resourceId) {
            throw new UnsupportedOperationException("TODO: CTCI 15.4 Deadlock-Free Class");
        }
    }
}
