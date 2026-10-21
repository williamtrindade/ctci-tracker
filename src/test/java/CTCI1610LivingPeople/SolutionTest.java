package CTCI1610LivingPeople;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static int brute(Person[] people, int min, int max) {
        int best = min;
        int bestCount = -1;
        for (int year = min; year <= max; year++) {
            int count = 0;
            for (Person p : people) {
                if (p.birth() <= year && year <= p.death()) {
                    count++;
                }
            }
            if (count > bestCount) {
                bestCount = count;
                best = year;
            }
        }
        return best;
    }

    @Test
    void example() {
        Person[] people = {
                new Person(1912, 1915), new Person(1920, 1990), new Person(1910, 1998), new Person(1901, 1972),
                new Person(1910, 1998), new Person(1923, 1982), new Person(1913, 1998), new Person(1990, 1998),
                new Person(1983, 1999), new Person(1975, 1994)
        };
        assertEquals(brute(people, 1900, 2000), solution.maxAliveYear(people, 1900, 2000));
    }

    @Test
    void deathYearCounts() {
        Person[] people = {new Person(1908, 1909), new Person(1909, 1950)};
        assertEquals(1909, solution.maxAliveYear(people, 1900, 2000));
    }

    @Test
    void tieReturnsEarliestYear() {
        Person[] people = {new Person(1950, 1951), new Person(1980, 1981)};
        assertEquals(1950, solution.maxAliveYear(people, 1900, 2000));
    }

    @Test
    void randomPeople() {
        Random random = new Random(10);
        for (int t = 0; t < 200; t++) {
            Person[] people = new Person[random.nextInt(50) + 1];
            for (int i = 0; i < people.length; i++) {
                int birth = 1900 + random.nextInt(101);
                int death = birth + random.nextInt(2000 - birth + 1);
                people[i] = new Person(birth, death);
            }
            assertEquals(brute(people, 1900, 2000), solution.maxAliveYear(people, 1900, 2000));
        }
    }
}
