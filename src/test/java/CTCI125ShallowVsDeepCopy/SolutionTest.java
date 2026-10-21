package CTCI125ShallowVsDeepCopy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

class SolutionTest {

    private static Person ana() {
        return new Person("Ana", new Address("Rua A, 1"), new ArrayList<>(List.of("1111")));
    }

    @Test
    void shallowCopySharesReferences() {
        Person original = ana();
        Person copy = Solution.shallowCopy(original);
        assertNotSame(original, copy);
        assertSame(original.getAddress(), copy.getAddress());
        assertSame(original.getPhones(), copy.getPhones());
        copy.getAddress().setStreet("Rua B, 2");
        assertEquals("Rua B, 2", original.getAddress().getStreet(), "Alterar a cópia rasa afeta o original");
        copy.setName("Bia");
        assertEquals("Ana", original.getName(), "Campos primitivos/imutáveis são independentes");
    }

    @Test
    void deepCopyIsIndependent() {
        Person original = ana();
        Person copy = Solution.deepCopy(original);
        assertNotSame(original.getAddress(), copy.getAddress());
        assertNotSame(original.getPhones(), copy.getPhones());
        assertEquals("Rua A, 1", copy.getAddress().getStreet());
        assertEquals(List.of("1111"), copy.getPhones());
        copy.getAddress().setStreet("Rua B, 2");
        copy.getPhones().add("2222");
        assertEquals("Rua A, 1", original.getAddress().getStreet());
        assertEquals(List.of("1111"), original.getPhones());
    }
}
