package CTCI91StockData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private Solution.StockDataService service;
    private final LocalDate d1 = LocalDate.of(2026, 10, 14);
    private final LocalDate d2 = LocalDate.of(2026, 10, 15);
    private final LocalDate d3 = LocalDate.of(2026, 10, 16);

    @BeforeEach
    void setUp() {
        service = new Solution.StockDataService();
        service.addRecord(new StockRecord("GOOG", d3, 3, 4, 5, 2));
        service.addRecord(new StockRecord("GOOG", d1, 1, 2, 3, 0.5));
        service.addRecord(new StockRecord("GOOG", d2, 2, 3, 4, 1));
        service.addRecord(new StockRecord("AAPL", d1, 10, 11, 12, 9));
    }

    @Test
    void getRecord() {
        assertEquals(2, service.getRecord("GOOG", d2).open());
        assertNull(service.getRecord("GOOG", LocalDate.of(2020, 1, 1)));
        assertNull(service.getRecord("MSFT", d1));
    }

    @Test
    void rangeQueriesAreSortedAndInclusive() {
        List<StockRecord> records = service.getRecords("GOOG", d1, d2);
        assertEquals(List.of(d1, d2), records.stream().map(StockRecord::date).toList());
        assertEquals(3, service.getRecords("GOOG", d1, d3).size());
        assertTrue(service.getRecords("MSFT", d1, d3).isEmpty());
    }

    @Test
    void replacesSameSymbolAndDate() {
        service.addRecord(new StockRecord("AAPL", d1, 99, 99, 99, 99));
        assertEquals(99, service.getRecord("AAPL", d1).close());
        assertEquals(1, service.getRecords("AAPL", d1, d3).size());
    }

    @Test
    void symbolsInAlphabeticalOrder() {
        assertEquals(List.of("AAPL", "GOOG"), service.getSymbols());
    }

    @Test
    void xmlFormat() {
        assertEquals("<stock symbol=\"GOOG\" date=\"2026-10-14\"><open>1.0</open><close>2.0</close>"
                + "<high>3.0</high><low>0.5</low></stock>", service.toXml(service.getRecord("GOOG", d1)));
    }
}
