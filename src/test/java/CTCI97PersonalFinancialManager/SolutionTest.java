package CTCI97PersonalFinancialManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private Solution.FinanceManager manager;
    private final YearMonth october = YearMonth.of(2026, 10);

    @BeforeEach
    void setUp() {
        manager = new Solution.FinanceManager();
        manager.addCategoryRule("uber", "Transport");
        manager.addCategoryRule("ifood", "Food");
        manager.addCategoryRule("market", "Groceries");
        manager.addCategoryRule("uber eats", "Food"); // nunca usada: "uber" vem antes
    }

    @Test
    void categorizesByMerchantRules() {
        manager.addTransaction("ana", LocalDate.of(2026, 10, 1), "UBER *TRIP", 20);
        manager.addTransaction("ana", LocalDate.of(2026, 10, 2), "Uber Eats", 30);
        manager.addTransaction("ana", LocalDate.of(2026, 10, 3), "iFood", 45.5);
        manager.addTransaction("ana", LocalDate.of(2026, 10, 4), "SuperMarket XYZ", 100);
        manager.addTransaction("ana", LocalDate.of(2026, 10, 5), "Cinema", 25);
        assertEquals(Map.of("Transport", 50.0, "Food", 45.5, "Groceries", 100.0, "Other", 25.0),
                manager.spendingByCategory("ana", october));
    }

    @Test
    void onlyTheRequestedMonthAndUser() {
        manager.addTransaction("ana", LocalDate.of(2026, 9, 30), "uber", 10);
        manager.addTransaction("ana", LocalDate.of(2026, 10, 1), "uber", 15);
        manager.addTransaction("bob", LocalDate.of(2026, 10, 1), "uber", 99);
        assertEquals(Map.of("Transport", 15.0), manager.spendingByCategory("ana", october));
        assertTrue(manager.spendingByCategory("carol", october).isEmpty());
    }

    @Test
    void overBudget() {
        manager.setBudget("ana", "Food", 50);
        manager.setBudget("ana", "Transport", 100);
        manager.setBudget("ana", "Groceries", 10);
        manager.addTransaction("ana", LocalDate.of(2026, 10, 1), "ifood", 30);
        manager.addTransaction("ana", LocalDate.of(2026, 10, 9), "ifood", 30);
        manager.addTransaction("ana", LocalDate.of(2026, 10, 9), "uber", 100);
        manager.addTransaction("ana", LocalDate.of(2026, 10, 9), "market", 10.5);
        assertEquals(List.of("Food", "Groceries"), manager.overBudgetCategories("ana", october));
    }
}
