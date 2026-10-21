package CTCI96SalesRank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private Solution.SalesRank rank;
    private final LocalDate today = LocalDate.of(2026, 10, 18);

    @BeforeEach
    void setUp() {
        rank = new Solution.SalesRank();
        rank.registerProduct("ball", Set.of("Sports"));
        rank.registerProduct("helmet", Set.of("Sports", "Safety"));
        rank.registerProduct("gloves", Set.of("Safety"));
        rank.registerProduct("book", Set.of("Books"));

        rank.recordSale("ball", today, 5);
        rank.recordSale("ball", today.minusDays(1), 5);
        rank.recordSale("helmet", today.minusDays(2), 7);
        rank.recordSale("gloves", today, 3);
        rank.recordSale("book", today.minusDays(10), 100); // fora da janela de 7 dias
        rank.recordSale("book", today, 1);
    }

    @Test
    void overallRanking() {
        assertEquals(List.of("ball", "helmet", "gloves", "book"), rank.topProducts(null, today, 7, 10));
        assertEquals(List.of("ball", "helmet"), rank.topProducts(null, today, 7, 2));
    }

    @Test
    void categoryRanking() {
        assertEquals(List.of("ball", "helmet"), rank.topProducts("Sports", today, 7, 10));
        assertEquals(List.of("helmet", "gloves"), rank.topProducts("Safety", today, 7, 10));
        assertEquals(2, rank.rankOf("helmet", null, today, 7));
        assertEquals(1, rank.rankOf("helmet", "Safety", today, 7));
        assertEquals(-1, rank.rankOf("gloves", "Sports", today, 7));
    }

    @Test
    void timeWindowMatters() {
        assertEquals(List.of("book", "ball", "helmet", "gloves"), rank.topProducts(null, today, 30, 10));
        assertEquals(List.of("ball", "gloves", "book"), rank.topProducts(null, today, 1, 10));
    }

    @Test
    void tiesAreBrokenById() {
        rank.recordSale("gloves", today, 7); // gloves = 10 = ball
        assertEquals(List.of("ball", "gloves", "helmet", "book"), rank.topProducts(null, today, 7, 10));
    }
}
