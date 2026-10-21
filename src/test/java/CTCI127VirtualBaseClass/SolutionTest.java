package CTCI127VirtualBaseClass;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void closingThroughBaseReferenceReleasesEverything() {
        List<String> log = new ArrayList<>();
        try (Solution.Base resource = new Solution.Derived(log)) {
            log.add("using");
        }
        assertEquals(List.of("Base opened", "Derived opened", "using", "Derived closed", "Base closed"), log);
    }

    @Test
    void baseAlone() {
        List<String> log = new ArrayList<>();
        try (Solution.Base resource = new Solution.Base(log)) {
            log.add("using");
        }
        assertEquals(List.of("Base opened", "using", "Base closed"), log);
    }
}
