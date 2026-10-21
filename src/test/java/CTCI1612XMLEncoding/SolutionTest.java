package CTCI1612XMLEncoding;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();
    private final Map<String, Integer> codes = Map.of("family", 1, "person", 2, "firstName", 3, "lastName", 4, "state", 5);

    @Test
    void bookExample() {
        Element person = Element.withValue("person", List.of(new Attribute("firstName", "Gayle")), "Some Message");
        Element family = Element.withChildren("family",
                List.of(new Attribute("lastName", "McDowell"), new Attribute("state", "CA")), List.of(person));
        assertEquals("1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0", solution.encode(family, codes));
    }

    @Test
    void elementWithoutAttributesOrChildren() {
        assertEquals("2 0 0", solution.encode(Element.withChildren("person", List.of(), List.of()), codes));
    }

    @Test
    void severalChildren() {
        Element a = Element.withValue("person", List.of(new Attribute("firstName", "Ana")), "Hi");
        Element b = Element.withChildren("person", List.of(new Attribute("firstName", "Bob")), List.of());
        Element family = Element.withChildren("family", List.of(), List.of(a, b));
        assertEquals("1 0 2 3 Ana 0 Hi 0 2 3 Bob 0 0 0", solution.encode(family, codes));
    }
}
