package CTCI154DeadlockFreeClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void bookExample() {
        // A = {1, 2, 3, 4}, B = {1, 3, 5}, C = {7, 5, 9, 2}: C cria o ciclo 2 -> 3 -> 5 -> 9 -> 2
        Solution.LockFactory factory = new Solution.LockFactory(10);
        assertTrue(factory.declare(1, new int[]{1, 2, 3, 4}));
        assertTrue(factory.declare(2, new int[]{1, 3, 5}));
        assertFalse(factory.declare(3, new int[]{7, 5, 9, 2}));
        assertNull(factory.getLock(3, 7), "Declaração rejeitada não dá direito a locks");
    }

    @Test
    void rejectedDeclarationDoesNotChangeTheGraph() {
        Solution.LockFactory factory = new Solution.LockFactory(5);
        assertTrue(factory.declare(1, new int[]{0, 1}));
        assertFalse(factory.declare(2, new int[]{1, 0}));
        // se a aresta 1->0 tivesse ficado, o grafo teria um ciclo e tudo passaria a ser rejeitado
        assertTrue(factory.declare(3, new int[]{2, 3}));
        assertTrue(factory.declare(4, new int[]{0, 1, 2}));
    }

    @Test
    void locksAreSharedPerResource() {
        Solution.LockFactory factory = new Solution.LockFactory(3);
        assertTrue(factory.declare(1, new int[]{0, 1}));
        assertTrue(factory.declare(2, new int[]{1, 2}));
        assertNotNull(factory.getLock(1, 0));
        assertSame(factory.getLock(1, 1), factory.getLock(2, 1));
        assertNull(factory.getLock(1, 2), "Recurso não declarado pelo dono");
        assertNull(factory.getLock(99, 0), "Dono desconhecido");
    }

    @Test
    void selfConsistentOrdersAreAccepted() {
        Solution.LockFactory factory = new Solution.LockFactory(6);
        assertTrue(factory.declare(1, new int[]{0, 1, 2, 3, 4, 5}));
        assertTrue(factory.declare(2, new int[]{0, 5}));
        assertTrue(factory.declare(3, new int[]{1, 4}));
        assertFalse(factory.declare(4, new int[]{5, 0}));
        assertFalse(factory.declare(5, new int[]{3, 1}));
    }
}
