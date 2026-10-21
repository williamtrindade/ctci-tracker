package CTCI137LambdaExpressions;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private final List<Country> countries = List.of(
            new Country("Brazil", "South America", 203),
            new Country("Argentina", "South America", 46),
            new Country("Portugal", "Europe", 10),
            new Country("Spain", "Europe", 48),
            new Country("Japan", "Asia", 124)
    );

    @Test
    void sumsPopulationOfContinent() {
        assertEquals(249, solution.getPopulation(countries, "South America"));
        assertEquals(58, solution.getPopulation(countries, "Europe"));
        assertEquals(124, solution.getPopulation(countries, "Asia"));
    }

    @Test
    void unknownContinentOrEmptyList() {
        assertEquals(0, solution.getPopulation(countries, "Antarctica"));
        assertEquals(0, solution.getPopulation(List.of(), "Europe"));
    }
}
